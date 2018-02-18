package com.hostel9.android.hostel9app.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hostel9.android.hostel9app.R;
import com.hostel9.android.hostel9app.adapter.MessAdapter;
import com.hostel9.android.hostel9app.database.DatabaseHelper;
import com.hostel9.android.hostel9app.model.Mess;
import com.hostel9.android.hostel9app.rest.ApiClient;
import com.hostel9.android.hostel9app.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MessFragment extends Fragment {

    private static final String TAG = "MESS_fragment";
    DatabaseHelper db;
    List<Mess> messs;

    public MessFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DatabaseHelper(getActivity());
        messs = db.getAllMesses();

        final RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (messs.size()==0)
        {
            ApiInterface apiService =
                    ApiClient.getClient().create(ApiInterface.class);

            Call<List<Mess>> call = apiService.getMessWeek(/*API_KEY*/);
            call.enqueue(new Callback<List<Mess>>() {
                @Override
                public void onResponse(Call<List<Mess>>call, Response<List<Mess>> response) {
                    //  Collection<Mess> messs =response.body().getResults();
                    List<Mess> api_messs = response.body();

                    int updated=0;
                    for (int i=0; i<api_messs.size(); i++)
                    {
                        db.updateMessifFound(api_messs.get(i));
                        updated++;
                    }
//                    recyclerView.setAdapter(new MessAdapter(messs, R.layout.list_messs, getApplicationContext()));
                    messs = api_messs;
                    Toast.makeText(getActivity(), "loaded from api", Toast.LENGTH_SHORT).show();


                    Log.d("Mess fragment", "Number of messs received: " + messs.size());
                }


                @Override
                public void onFailure(Call<List<Mess>>call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });
        }


        recyclerView.setAdapter(new MessAdapter(messs, R.layout.list_mess, getActivity()));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for getActivity() fragment
        return inflater.inflate(R.layout.fragment_mess, container, false);
    }


}
