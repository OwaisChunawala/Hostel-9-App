package com.hostel9.android.hostel9app;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.internal.bind.DateTypeAdapter;
import com.hostel9.android.hostel9app.Adapters.CouncilFramgentPageAdapter;
import com.hostel9.android.hostel9app.Fragments.CMSFragment;
import com.hostel9.android.hostel9app.Fragments.CouncilFragment;
import com.hostel9.android.hostel9app.Fragments.EventsFragment;
import com.hostel9.android.hostel9app.Fragments.FacilitiesFragment;
import com.hostel9.android.hostel9app.Fragments.HelplineFragment;
import com.hostel9.android.hostel9app.Fragments.HomeFragment;
import com.hostel9.android.hostel9app.adapter.EventAdapter;
import com.hostel9.android.hostel9app.database.DatabaseHelper;
import com.hostel9.android.hostel9app.model.Event;
import com.hostel9.android.hostel9app.model.Mess;
import com.hostel9.android.hostel9app.rest.ApiClient;
import com.hostel9.android.hostel9app.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private Fragment fragment = null;
    private static final String TAG = MainActivity.class.getSimpleName();

    DatabaseHelper db1;
    List<Mess> messs;
    List<Event> events;
    RecyclerView recyclerView;
    EventsFragment eventFragment;
    FragmentTransaction fragmentTransaction;
    HomeFragment homeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MAIN ACTIVITY", "MAIN ACTIVITY ON CREATE");

        // defining important objects.
        db1 = new DatabaseHelper(this);
        eventFragment = new EventsFragment();
        fragmentManager = getSupportFragmentManager();

        homeFragment = new HomeFragment();
        openFragment(homeFragment, "HomeFragment");

        // for Navigation Drawer
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewEvents);
//        events = db1.getAllEvents();
//        new LongOperation().execute("");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        View header = navigationView.inflateHeaderView(R.layout.nav_header_main);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_cms) {
                    CMSFragment cmsFragment = new CMSFragment();
                    if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                        getSupportFragmentManager().popBackStack();
                    }
                    openFragment(cmsFragment, "CMS fragment");

                } else if (id == R.id.nav_council) {
                    CouncilFragment councilFramgent = new CouncilFragment();
                    if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                        getSupportFragmentManager().popBackStack();
                    }
                    openFragment(councilFramgent, "Council fragment");

                } else if (id == R.id.nav_home) {
                    HomeFragment homeFragment = new HomeFragment();
                    if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                        getSupportFragmentManager().popBackStack();
                    }
                    openFragment(homeFragment, "Home fragment");

                } else if (id == R.id.nav_helpline) {
                    HelplineFragment helplineFragment = new HelplineFragment();
                    if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                        getSupportFragmentManager().popBackStack();
                    }
                    openFragment(helplineFragment, "Helpline fragment");
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                assert drawer != null;
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

        });

        // taking the data from the api
        // checking if connected to the internet
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else
            connected = false;

        if (connected) {
            // if connected, then update the tables from the api
            updateMess(db1);
            updateEvents(db1);
            Log.d("MAIN ACTIVITY", "UPDATED THE DATA");
        } else
            Toast.makeText(MainActivity.this, "Check your internet connection", Toast.LENGTH_LONG).show();
    }

// For upadating the mess information from the api

    public void updateMess(final DatabaseHelper db) {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Log.d(TAG, "downloading the MESS DATA");

        Call<List<Mess>> call = apiService.getMessWeek(/*API_KEY*/);
        call.enqueue(new Callback<List<Mess>>() {

            @Override
            public void onResponse(Call<List<Mess>> call, Response<List<Mess>> response) {

                //  downloading the data and storing in api_mess
                List<Mess> api_messs = response.body();
                Log.d("UPDATE_MESS", "downloaded the RESPONSE, now updating tables");

                // to delete the previous tables and update the tables with new data
                db.upgradeMess();

                for (int i = 0; i < api_messs.size(); i++) {
                    db.createMess(api_messs.get(i));
                }
                Log.d("UPDATE_MESS", "TABLES UPDATED, Number of messs received: " + api_messs.size());
            }


            @Override
            public void onFailure(Call<List<Mess>> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                Log.d("UPDATE_MESS", "CANT DOWNLOAD");
            }
        });

    }

    // updating the events
    public void updateEvents(final DatabaseHelper db) {

        ApiInterface apiService2 = ApiClient.getClient().create(ApiInterface.class);
        Log.d(TAG, "downloading the EVENTS DATA");

        Call<List<Event>> call2 = apiService2.getEvents(/*API_KEY*/);
        call2.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {

                //  downloading the data and storing in api_events
                List<Event> api_events = response.body();
                Log.d("UPDATE EVENTS", "INSIDE CALL. Events   RECIEVED : " + api_events.size());

                // to delete the previous tables and update the tables with new data
                db.upgradeEvent();

                for (int i = 0; i < api_events.size(); i++)
                    db.updateEventifFound(api_events.get(i));

                Log.d("UPDATE EVENTS", "DATA UPDATED IN TABLES");
            }


            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                Log.d("UPDATE EVENTS", "CANT DOWNLOAD");
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_container_wrapper);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (currentFragment instanceof HomeFragment) {
            Log.e("BackButtonIssues", "Current Fragment is main fragment");
//            super.onBackPressed();
            this.finishAffinity();
        } else {
            super.onBackPressed();
        }
    }


    public void openFragment(Fragment fragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Log.d("OPEN FRAGMENT", "RELACING THE FRAGMENT...");
        //ft.setCustomAnimations(R.anim.slide_out_from_left,R.anim.slide_in_from_right);
        ft.replace(R.id.main_container_wrapper, fragment, fragment.getTag());
        ft.addToBackStack(tag);
        int count = getSupportFragmentManager().getBackStackEntryCount();
        Log.d("Back stack", "Back Stack count: " + count);
        ft.commit();
        getSupportFragmentManager().popBackStackImmediate("MainFragment", 0);

    }
}
// To create menu on the top, but seemed useless as onf now.

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.refresh:
//                Toast.makeText(MainActivity.this, "Updating...", Toast.LENGTH_SHORT).show();
//
//                updateMess(db1);
//                updateEvents(db1);
//
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                HomeFragment homeFragment = new HomeFragment();
//                fragmentTransaction.replace(R.id.main_container_wrapper, homeFragment);
//                fragmentTransaction.commit();
//                return true;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//}
