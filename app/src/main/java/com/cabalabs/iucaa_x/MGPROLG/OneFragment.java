package com.cabalabs.iucaa_x.MGPROLG;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
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

                            listobs.add("DATE_OBS: "+jsonObject.getString("date_obs"));
                            listobs.add(jsonObject.getString("time_obs"));
                            listobs.add(jsonObject.getString("date_end"));
                            listobs.add(jsonObject.getString("time_end"));
                            listobs.add(jsonObject.getString("obs_id"));
                            listobs.add(jsonObject.getString("exposure"));
                            listobs.add(jsonObject.getString("sourceid"));
                            listobs.add(jsonObject.getString("observer"));
                            listobs.add(jsonObject.getString("ra_pnt"));
                            listobs.add(jsonObject.getString("dec_pnt"));

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

        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(request);
    }

}