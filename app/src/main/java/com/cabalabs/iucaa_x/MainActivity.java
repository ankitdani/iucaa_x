package com.cabalabs.iucaa_x;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.cabalabs.iucaa_x.MGPROLG.MergedProLog;
import com.cabalabs.iucaa_x.MOBSID.MergOBSID;
import com.cabalabs.iucaa_x.PROBPGS.ProblemPg;
import com.cabalabs.iucaa_x.PXHIST.PixHistory;
import com.cabalabs.iucaa_x.THRESHIST.ModThresAct;
import com.cabalabs.iucaa_x.UOBSID.UpOBSID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * Class Contains All the Functions to Set Up a Recycler View To fetch The Summary of Astrosat DQRs
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        SwipeRefreshLayout.OnRefreshListener {

    /**
     *
     */
    String URL;

    JsonArrayRequest request;
    RequestQueue requestQueue;

    List<Summary> listSumm = new ArrayList<Summary>();
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URL = getString(R.string.IP_Summary);

        if(isOnline()){

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    MainActivity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(MainActivity.this);

            recyclerView = findViewById(R.id.recyclerviewid);
            jsonrequest();
        }
        else{
            Toast.makeText(MainActivity.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();

        }

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.Swipe);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            /**
             * Refreshes the Contents of the Summary Page of DQRs
             */
            @Override
            public void onRefresh() {

                if(isOnline()){

                    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                    setSupportActionBar(toolbar);

                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                            MainActivity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                    drawer.addDrawerListener(toggle);
                    toggle.syncState();

                    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                    navigationView.setNavigationItemSelectedListener(MainActivity.this);

                    recyclerView = findViewById(R.id.recyclerviewid);
                    listSumm.clear();
                    jsonrequest();
                }
                else{
                    Toast.makeText(MainActivity.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        swipeRefreshLayout.setRefreshing(false);        //to stop refreshing
                    }
                }, 1000);
            }
        });
    }


    public boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }


    /**
     * Fetches JSON Array as a response from Django REST API
     *
     */

    private void jsonrequest() {

        request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for(int i=0; i<response.length(); i++){

                    try{

                        //jsonObject to fetch the related response from the JSON array
                        jsonObject = response.getJSONObject(i);

                        Summary summary = new Summary();

                        // Fetches the required Data  as specfied in getString parameter
                        summary.setUID(jsonObject.getString("UID"));
                        summary.setFolder(jsonObject.getString("folder"));
                        summary.setObserver(jsonObject.getString("Observer"));

                        //Adds to the Recycler View
                        listSumm.add(summary);

                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(listSumm);

            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        });

        //Request Queue for Fetching the response using Google Volley

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }


    private void setuprecyclerview(List<Summary> listSumm) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,listSumm);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }


    // Default Action Functions for a Navigation Drawer

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.orbit_wise) {
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.merged_obsid_wise) {
            Intent intent = new Intent(MainActivity.this, MergOBSID.class);
            startActivity(intent);
        } else if (id == R.id.upload_obsid_wise) {
            Intent intent = new Intent(MainActivity.this, UpOBSID.class);
            startActivity(intent);
        } else if (id == R.id.merged_processing_logs) {
            Intent intent = new Intent(MainActivity.this,MergedProLog.class);
            startActivity(intent);
        } else if (id == R.id.problem_pages) {
            Intent intent = new Intent(MainActivity.this, ProblemPg.class);
            startActivity(intent);
        } else if (id == R.id.pixel_enable) {
            Intent intent = new Intent(MainActivity.this, PixHistory.class);
            startActivity(intent);
        } else if (id == R.id.module_threshold_history) {
            Intent intent = new Intent(MainActivity.this, ModThresAct.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onRefresh() {

    }
}
