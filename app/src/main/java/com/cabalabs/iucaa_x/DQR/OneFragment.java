package com.cabalabs.iucaa_x.DQR;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.cabalabs.iucaa_x.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends Fragment{

    public OneFragment() {
        // Required empty public constructor
    }

    String URL;
    JsonArrayRequest request;
    RequestQueue requestQueue;
    ListView lst;
    List<String> listobs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        URL = getString(R.string.IP_OBSInfo);
        jsonrequest();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    /**
     *Creates a new connection with the Django web server
     *Sends request to the Django API for retrieving the Observation Information of a particular observation
     *Retrieves JSON data and stores into a JSON object 'response'
     *Compares the uid attribute stored in JSON object that is combination of folder name and OBSID with the UID selected in the Main Activity
     *When found adds each attribute to the android listview and displays required data
     */
    private void jsonrequest() {

        request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = new JSONObject();


                String uidprev = getActivity().getIntent().getExtras().getString("UID");
                Log.e("Received",String.valueOf(uidprev));


                for(int i=0; i<response.length(); i++){

                    try{

                        jsonObject = response.getJSONObject(i);

                        String uid = jsonObject.getString("UID");
                        Log.e("Actual",uid);

                        if(uid.equals(uidprev)) {

                            listobs = new ArrayList<String>();

                            listobs.add("DATE_OBS "+jsonObject.getString("date_obs"));
                            listobs.add("TIME_OBS "+jsonObject.getString("time_obs"));
                            listobs.add("DATE_END "+jsonObject.getString("date_end"));
                            listobs.add("TIME_END "+jsonObject.getString("time_end"));
                            listobs.add("OBS_ID "+jsonObject.getString("obs_id"));
                            listobs.add("EXPOSURE "+jsonObject.getString("exposure"));
                            listobs.add("SOURCE_ID "+jsonObject.getString("sourceid"));
                            listobs.add("OBSERVER "+jsonObject.getString("observer"));
                            listobs.add("RA_PNT "+jsonObject.getString("ra_pnt"));
                            listobs.add("DEC_PNT "+jsonObject.getString("dec_pnt"));

                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                                    getActivity().getApplicationContext(),
                                    android.R.layout.simple_list_item_1,
                                    listobs);


                            lst = (ListView) getView().findViewById(R.id.listview);
                            lst.setAdapter(adapter);

                        }

                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        });

        /**
         * Unique request queue for each fragment that avoids dependency issues and reduces risk of failure
         */
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(request);
    }

}