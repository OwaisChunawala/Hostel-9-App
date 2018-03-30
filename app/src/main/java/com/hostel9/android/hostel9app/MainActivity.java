package com.hostel9.android.hostel9app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.hostel9.android.hostel9app.Adapters.CouncilFramgentPageAdapter;
import com.hostel9.android.hostel9app.Fragments.CMSFragment;
import com.hostel9.android.hostel9app.Fragments.CouncilFragment;
import com.hostel9.android.hostel9app.Fragments.FacilitiesFragment;
import com.hostel9.android.hostel9app.Fragments.HelplineFragment;
import com.hostel9.android.hostel9app.Fragments.HomeFragment;
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

    DatabaseHelper db;
    List<Mess> messs;
    List<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MAIN ACTIVITY", "MAIN ACTIVITY ON CREATE" );

        db = new DatabaseHelper(this);

        updateMess();
        updateEvents();

//        Log.d("MAIN ACTIVITY", "MAIN ACTIVITY EVENTS SIZE: " + events.size() );

        // taking the data from the api
        // checking if connected to the internet
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;

//        if (connected){

            // if connected, then update the tables from the api


//        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragment = new HomeFragment();
//        fragmentTransaction.replace(R.id.main_container_wrapper, fragment);
//        fragmentTransaction.commit();
        HomeFragment homeFragment = new HomeFragment();
        openFragment(homeFragment, "HomeFragment");
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        View header = navigationView.inflateHeaderView(R.layout.nav_header_main);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_cms) {
                    CMSFragment cmsFragment = new CMSFragment();
                    if(getSupportFragmentManager().getBackStackEntryCount() >1){
                        getSupportFragmentManager().popBackStack();
                    }
                    openFragment(cmsFragment,"CMS fragment");

                }
                else if (id == R.id.nav_council) {
                    CouncilFragment councilFramgent = new  CouncilFragment();
                    if(getSupportFragmentManager().getBackStackEntryCount() >1){
                        getSupportFragmentManager().popBackStack();
                    }
                    openFragment(councilFramgent,"Council fragment");
                }
                else if (id == R.id.nav_helpline) {
                    HelplineFragment helplineFragment = new HelplineFragment();
                    if(getSupportFragmentManager().getBackStackEntryCount() >1){
                        getSupportFragmentManager().popBackStack();
                    }
                    openFragment(helplineFragment,"Helpline fragment");
                }

//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.replace(R.id.main_container_wrapper, fragment);
//                transaction.addToBackStack("Added the frag to bstack");
//                transaction.commit();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                assert drawer != null;
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });



    }


    public void updateMess (){
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Log.d("Mess fragment", "downloading the MESS DATA" );

        Call<List<Mess>> call = apiService.getMessWeek(/*API_KEY*/);
        call.enqueue(new Callback<List<Mess>>() {

            @Override
            public void onResponse(Call<List<Mess>>call, Response<List<Mess>> response) {
                //  Collection<Mess> messs =response.body().getResults();
                Log.d("Mess fragment", "downloading the BEFORE RESPONSE " );
                List<Mess> api_messs = response.body();

                Log.d("Mess fragment", "downloading the data2" );


                db.upgradeMess();
                int updated=0;
                for (int i=0; i<api_messs.size(); i++)
                {
                    db.createMess(api_messs.get(i));
                    updated++;
                }
//                    recyclerView.setAdapter(new MessAdapter(messs, R.layout.list_messs, getApplicationContext()));
                messs = api_messs;
                Toast.makeText(getApplicationContext(), "loaded from api", Toast.LENGTH_LONG).show();


                Log.d("Mess fragment", "Number of messs received: " + messs.size());
            }


            @Override
            public void onFailure(Call<List<Mess>>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                Log.d("Mess fragment", "CANT DOWNLOAD" );
            }
        });

    }

    public void updateEvents(){

        // taking the events

        ApiInterface apiService2 =
                ApiClient.getClient().create(ApiInterface.class);

        Log.d("events fragment", "downloading the EVENTS DATA" );

        Call<List<Event>> call2 = apiService2.getEvents(/*API_KEY*/);
        call2.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>>call, Response<List<Event>> response) {
                //  Collection<Event> messs =response.body().getResults();
                List<Event> api_events = response.body();

                Log.d("MAIN ACTIVITY", "INSIDE CALL. ENZQUEUE   RECIEVED : " + api_events.size() );

                Log.d("Event fragment", "downloading the data2" );


                int updated=0;

                db.upgradeEvent();

                for (int i=0; i<api_events.size(); i++)
                {
                    db.updateEventifFound(api_events.get(i));
                    updated++;
                }


                Toast.makeText(getApplicationContext(), "loaded from api" + api_events.size(), Toast.LENGTH_LONG).show();


                Log.d("Event fragment", "Number of messs received: " + api_events.size());
            }


            @Override
            public void onFailure(Call<List<Event>>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                Log.d("EVENT fragment", "CANT DOWNLOAD" );
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_container_wrapper);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(currentFragment instanceof HomeFragment){
            Log.e("BackButtonIssues", "Current Fragment is main fragment");
//            super.onBackPressed();
            this.finishAffinity();
        }
        else {
            super.onBackPressed();
        }
    }


    public void openFragment(Fragment fragment, String tag){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //ft.setCustomAnimations(R.anim.slide_out_from_left,R.anim.slide_in_from_right);
        ft.replace(R.id.main_container_wrapper, fragment, fragment.getTag());
        ft.addToBackStack(tag);
        int count = getSupportFragmentManager().getBackStackEntryCount();
        Log.e("Back stack", "Back Stack count: " + count);
        ft.commit();
        getSupportFragmentManager().popBackStackImmediate("MainFragment", 0);

    }

}
