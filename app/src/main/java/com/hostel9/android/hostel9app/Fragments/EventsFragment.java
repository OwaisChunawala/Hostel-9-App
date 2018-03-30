package com.hostel9.android.hostel9app.Fragments;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.net.Uri;
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
import android.os.AsyncTask;

import com.hostel9.android.hostel9app.MainActivity;
import com.hostel9.android.hostel9app.R;
import com.hostel9.android.hostel9app.adapter.EventAdapter;
import com.hostel9.android.hostel9app.adapter.MessAdapter;
import com.hostel9.android.hostel9app.database.DatabaseHelper;
import com.hostel9.android.hostel9app.model.Event;
import com.hostel9.android.hostel9app.model.Event;
import com.hostel9.android.hostel9app.rest.ApiClient;
import com.hostel9.android.hostel9app.rest.ApiInterface;

import java.util.List;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsFragment extends Fragment  {

    private static final String TAG = "MESS_fragment";
    DatabaseHelper db;
    List<Event> events;
    SwipeRefreshLayout mySwipeRefreshLayout;
    Context context;
    MainActivity mainActivity;
    RecyclerView recyclerView;

    public EventsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DatabaseHelper(getActivity());
        context = getActivity();
        mainActivity = new MainActivity();

        Log.d("Event fragment", "onCreate reached" );


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_events, container, false);
        mySwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshevent);
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerViewEvents);

        mainActivity.updateEvents(db);
        Log.d("Event fragment", "onCreateView reached" );
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("Event fragment", "onViewCreated reached, calling loadData" );
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

        Log.d("Event fragment", "LoadData reached" );
        events = db1.getAllEvents();
        if (events.size()==0)
        {
            Toast.makeText(getActivity(), "Swipe down to update the data...", Toast.LENGTH_LONG).show();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        EventAdapter eventAdapter = new EventAdapter(events,R.layout.list_events, recyclerView, getActivity());
        recyclerView.setAdapter(eventAdapter);

        Log.d("Event fragment", "Loading data done" );



    }

    public class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            mainActivity.updateEvents(db);
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


