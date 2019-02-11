package com.cabalabs.iucaa_x;

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
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TwoFragment extends Fragment{

    public TwoFragment() {
        // Required empty public constructor
    }

    final String URL = "http://192.168.43.12:8000/dqrreport/dqrstats";
    JsonArrayRequest request;
    RequestQueue requestQueue;

    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        jsonrequest();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
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


                            String of1 = jsonObject.getString("filename_OF");
                            String ff1 = jsonObject.getString("filename_FF");
                            String of2 = jsonObject.getString("size_bytes_OF");
                            String ff2 = jsonObject.getString("size_bytes_FF");
                            String of3 = jsonObject.getString("size_OF");
                            String ff3 = jsonObject.getString("size_FF");
                            String of4 = jsonObject.getString("events_quadA_OF");
                            String ff4 = jsonObject.getString("events_quadA_FF");
                            String of5 = jsonObject.getString("events_quadB_OF");
                            String ff5 = jsonObject.getString("events_quadB_FF");
                            String of6 = jsonObject.getString("events_quadC_OF");
                            String ff6 = jsonObject.getString("events_quadC_FF");
                            String of7 = jsonObject.getString("events_quadD_OF");
                            String ff7 = jsonObject.getString("events_quadD_FF");


                            textView = (TextView) getView().findViewById(R.id.of1);
                            textView.setText(of1);
                            textView1 = (TextView) getView().findViewById(R.id.of2);
                            textView1.setText(of2);
                            textView2 = (TextView) getView().findViewById(R.id.of3);
                            textView2.setText(of3);
                            textView3 = (TextView) getView().findViewById(R.id.of4);
                            textView3.setText(of4);
                            textView4 = (TextView) getView().findViewById(R.id.of5);
                            textView4.setText(of5);
                            textView5 = (TextView) getView().findViewById(R.id.of6);
                            textView5.setText(of6);
                            textView6 = (TextView) getView().findViewById(R.id.of7);
                            textView6.setText(of7);
                            textView7 = (TextView) getView().findViewById(R.id.ff1);
                            textView7.setText(ff1);
                            textView8 = (TextView) getView().findViewById(R.id.ff2);
                            textView8.setText(ff2);
                            textView9 = (TextView) getView().findViewById(R.id.ff3);
                            textView9.setText(ff3);
                            textView10 = (TextView) getView().findViewById(R.id.ff4);
                            textView10.setText(ff4);
                            textView11 = (TextView) getView().findViewById(R.id.ff5);
                            textView11.setText(ff5);
                            textView12 = (TextView) getView().findViewById(R.id.ff6);
                            textView12.setText(ff6);
                            textView13 = (TextView) getView().findViewById(R.id.ff7);
                            textView13.setText(ff7);


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