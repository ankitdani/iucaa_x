package com.cabalabs.iucaa_x;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String URL = "http://192.168.2.12:8000/iucaaapp/";
    JsonArrayRequest request;
    RequestQueue requestQueue;
    List<Summary> listSumm = new ArrayList<Summary>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for(int i=0; i<response.length(); i++){

                    try{

                        jsonObject = response.getJSONObject(i);
                        Summary summary = new Summary();
                        summary.setFolder(jsonObject.getString("folder"));
                        summary.setOBSID(jsonObject.getString("OBSID"));
                        summary.setObserver(jsonObject.getString("Observer"));
                        summary.setObject(jsonObject.getString("Object"));
                        summary.setRA(jsonObject.getString("RA"));
                        summary.setDecr(jsonObject.getString("Decr"));
                        summary.setExposure_time(jsonObject.getString("Exposure_time"));
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

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Summary> listSumm) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,listSumm);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }
}
