package com.hostel9.android.hostel9app.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hostel9.android.hostel9app.MainActivity;
import com.hostel9.android.hostel9app.R;
import com.hostel9.android.hostel9app.adapter.EventAdapter;
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
    SwipeRefreshLayout mySwipeRefreshLayout;
    Context context;
    MainActivity mainActivity;
    RecyclerView recyclerView;

    public MessFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DatabaseHelper(getActivity());
        context = getActivity();
        mainActivity = new MainActivity();

        Log.d("Mess fragment", "onCreate reached");
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for getActivity() fragment

        // update the data, define the elements, connect with UI
        mainActivity.updateMess(db);
        View view = inflater.inflate(R.layout.fragment_mess, container, false);
        mySwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //this method is called just after onCreateView. loadData method takes the data from database and load in recycler view
        loadData(db);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.i(TAG, "onRefresh called from SwipeRefreshLayout");
                        new LongOperation().execute("");
                        mySwipeRefreshLayout.setRefreshing(false);
                    }
                }
        );
    }



    public void loadData (DatabaseHelper db1) {

        Log.d("Mess fragment", "loadData  reached" );
        messs = db.getAllMesses();
        // in the start of app, on the first time, the UI is loaded first, but there is no data in the database to load yet,
        //  as the downloading from server happens after the UI is set.
        // so if the size of the data fetched is 0, asked the user to swipe, which reloads the view, and now database is updated,
        // so no problem. data loads smoothly.
        if (messs.size()==0)
        {
            Toast.makeText(getActivity(), "Swipe down to update the data...", Toast.LENGTH_LONG).show();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MessAdapter(messs, R.layout.list_mess, getActivity()));
        Log.d("Mess fragment", "recycler view mess set up " );
    }

    public class LongOperation extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {

            mainActivity.updateMess(db);
            Log.d(TAG, "Asynctask background done.");
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

            loadData(db);

            Log.d(TAG, "Asynctask PostExecute.");
        }
        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}
