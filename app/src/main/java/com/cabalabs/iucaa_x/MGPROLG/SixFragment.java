package com.cabalabs.iucaa_x.MGPROLG;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cabalabs.iucaa_x.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.cabalabs.iucaa_x.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SixFragment extends Fragment{

    public SixFragment() {
        // Required empty public constructor
    }

    String URL;
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
    TextView textView14;
    TextView textView15;
    TextView textView16;
    TextView textView17;
    TextView textView18;
    TextView textView19;
    TextView textView20;
    TextView textView21;
    TextView textView22;
    TextView textView23;
    TextView textView24;
    TextView textView25;
    TextView textView26;
    TextView textView27;
    TextView textView28;
    TextView textView29;
    TextView textView30;
    TextView textView31;
    TextView textView32;
    TextView textView33;
    TextView textView34;
    TextView textView35;

    TextView textView36;
    TextView textView37;
    TextView textView38;
    TextView textView39;
    TextView textView40;
    TextView textView41;
    TextView textView42;
    TextView textView43;
    TextView textView44;
    TextView textView45;
    TextView textView46;
    TextView textView47;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        URL = getString(R.string.IP_PP);
        jsonrequest();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_six, container, false);
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

                            String PP_QA1_DID = jsonObject.getString("PP_QA1_DID");
                            String PP_QA1_PID = jsonObject.getString("PP_QA1_PID");
                            String PP_QA1_CNT = jsonObject.getString("PP_QA1_CNT");
                            String PP_QA1_SG = jsonObject.getString("PP_QA1_SG");

                            String PP_QA2_DID = jsonObject.getString("PP_QA2_DID");
                            String PP_QA2_PID = jsonObject.getString("PP_QA2_PID");
                            String PP_QA2_CNT = jsonObject.getString("PP_QA2_CNT");
                            String PP_QA2_SG = jsonObject.getString("PP_QA2_SG");

                            String PP_QA3_DID = jsonObject.getString("PP_QA3_DID");
                            String PP_QA3_PID = jsonObject.getString("PP_QA3_PID");
                            String PP_QA3_CNT = jsonObject.getString("PP_QA3_CNT");
                            String PP_QA3_SG = jsonObject.getString("PP_QA3_SG");

                            String PP_QB1_DID = jsonObject.getString("PP_QB1_DID");
                            String PP_QB1_PID = jsonObject.getString("PP_QB1_PID");
                            String PP_QB1_CNT = jsonObject.getString("PP_QB1_CNT");
                            String PP_QB1_SG = jsonObject.getString("PP_QB1_SG");

                            String PP_QB2_DID = jsonObject.getString("PP_QB2_DID");
                            String PP_QB2_PID = jsonObject.getString("PP_QB2_PID");
                            String PP_QB2_CNT = jsonObject.getString("PP_QB2_CNT");
                            String PP_QB2_SG = jsonObject.getString("PP_QB2_SG");

                            String PP_QB3_DID = jsonObject.getString("PP_QB3_DID");
                            String PP_QB3_PID = jsonObject.getString("PP_QB3_PID");
                            String PP_QB3_CNT = jsonObject.getString("PP_QB3_CNT");
                            String PP_QB3_SG = jsonObject.getString("PP_QB3_SG");

                            String PP_QC1_DID = jsonObject.getString("PP_QC1_DID");
                            String PP_QC1_PID = jsonObject.getString("PP_QC1_PID");
                            String PP_QC1_CNT = jsonObject.getString("PP_QC1_CNT");
                            String PP_QC1_SG = jsonObject.getString("PP_QC1_SG");

                            String PP_QC2_DID = jsonObject.getString("PP_QC2_DID");
                            String PP_QC2_PID = jsonObject.getString("PP_QC2_PID");
                            String PP_QC2_CNT = jsonObject.getString("PP_QC2_CNT");
                            String PP_QC2_SG = jsonObject.getString("PP_QC2_SG");

                            String PP_QC3_DID = jsonObject.getString("PP_QC3_DID");
                            String PP_QC3_PID = jsonObject.getString("PP_QC3_PID");
                            String PP_QC3_CNT = jsonObject.getString("PP_QC3_CNT");
                            String PP_QC3_SG = jsonObject.getString("PP_QC3_SG");

                            String PP_QD1_DID = jsonObject.getString("PP_QD1_DID");
                            String PP_QD1_PID = jsonObject.getString("PP_QD1_PID");
                            String PP_QD1_CNT = jsonObject.getString("PP_QD1_CNT");
                            String PP_QD1_SG = jsonObject.getString("PP_QD1_SG");

                            String PP_QD2_DID = jsonObject.getString("PP_QD2_DID");
                            String PP_QD2_PID = jsonObject.getString("PP_QD2_PID");
                            String PP_QD2_CNT = jsonObject.getString("PP_QD2_CNT");
                            String PP_QD2_SG = jsonObject.getString("PP_QD2_SG");

                            String PP_QD3_DID = jsonObject.getString("PP_QD3_DID");
                            String PP_QD3_PID = jsonObject.getString("PP_QD3_PID");
                            String PP_QD3_CNT = jsonObject.getString("PP_QD3_CNT");
                            String PP_QD3_SG = jsonObject.getString("PP_QD3_SG");

                            textView = (TextView) getView().findViewById(R.id.PP_QA1_DID);
                            textView.setText(PP_QA1_DID);
                            textView1 = (TextView) getView().findViewById(R.id.PP_QA1_PID);
                            textView1.setText(PP_QA1_PID);
                            textView2 = (TextView) getView().findViewById(R.id.PP_QA1_CNT);
                            textView2.setText(PP_QA1_CNT);
                            textView3 = (TextView) getView().findViewById(R.id.PP_QA1_SG);
                            textView3.setText(PP_QA1_SG);

                            textView4 = (TextView) getView().findViewById(R.id.PP_QA2_DID);
                            textView4.setText(PP_QA2_DID);
                            textView5 = (TextView) getView().findViewById(R.id.PP_QA2_PID);
                            textView5.setText(PP_QA2_PID);
                            textView6 = (TextView) getView().findViewById(R.id.PP_QA2_CNT);
                            textView6.setText(PP_QA2_CNT);
                            textView7 = (TextView) getView().findViewById(R.id.PP_QA2_SG);
                            textView7.setText(PP_QA2_SG);

                            textView8 = (TextView) getView().findViewById(R.id.PP_QA3_DID);
                            textView8.setText(PP_QA3_DID);
                            textView9 = (TextView) getView().findViewById(R.id.PP_QA3_PID);
                            textView9.setText(PP_QA3_PID);
                            textView10 = (TextView) getView().findViewById(R.id.PP_QA3_CNT);
                            textView10.setText(PP_QA3_CNT);
                            textView11 = (TextView) getView().findViewById(R.id.PP_QA3_SG);
                            textView11.setText(PP_QA3_SG);

                            textView12 = (TextView) getView().findViewById(R.id.PP_QB1_DID);
                            textView12.setText(PP_QB1_DID);
                            textView13 = (TextView) getView().findViewById(R.id.PP_QB1_PID);
                            textView13.setText(PP_QB1_PID);
                            textView14 = (TextView) getView().findViewById(R.id.PP_QB1_CNT);
                            textView14.setText(PP_QB1_CNT);
                            textView15 = (TextView) getView().findViewById(R.id.PP_QB1_SG);
                            textView15.setText(PP_QB1_SG);

                            textView16 = (TextView) getView().findViewById(R.id.PP_QB2_DID);
                            textView16.setText(PP_QB2_DID);
                            textView17 = (TextView) getView().findViewById(R.id.PP_QB2_PID);
                            textView17.setText(PP_QB2_PID);
                            textView18 = (TextView) getView().findViewById(R.id.PP_QB2_CNT);
                            textView18.setText(PP_QB2_CNT);
                            textView19 = (TextView) getView().findViewById(R.id.PP_QB2_SG);
                            textView19.setText(PP_QB2_SG);

                            textView20 = (TextView) getView().findViewById(R.id.PP_QB3_DID);
                            textView20.setText(PP_QB3_DID);
                            textView21 = (TextView) getView().findViewById(R.id.PP_QB3_PID);
                            textView21.setText(PP_QB3_PID);
                            textView22 = (TextView) getView().findViewById(R.id.PP_QB3_CNT);
                            textView22.setText(PP_QB3_CNT);
                            textView23 = (TextView) getView().findViewById(R.id.PP_QB3_SG);
                            textView23.setText(PP_QB3_SG);

                            textView24 = (TextView) getView().findViewById(R.id.PP_QC1_DID);
                            textView24.setText(PP_QC1_DID);
                            textView25 = (TextView) getView().findViewById(R.id.PP_QC1_PID);
                            textView25.setText(PP_QC1_PID);
                            textView26 = (TextView) getView().findViewById(R.id.PP_QC1_CNT);
                            textView26.setText(PP_QC1_CNT);
                            textView27 = (TextView) getView().findViewById(R.id.PP_QC1_SG);
                            textView27.setText(PP_QC1_SG);

                            textView28 = (TextView) getView().findViewById(R.id.PP_QC2_DID);
                            textView28.setText(PP_QC2_DID);
                            textView29 = (TextView) getView().findViewById(R.id.PP_QC2_PID);
                            textView29.setText(PP_QC2_PID);
                            textView30 = (TextView) getView().findViewById(R.id.PP_QC2_CNT);
                            textView30.setText(PP_QC2_CNT);
                            textView31 = (TextView) getView().findViewById(R.id.PP_QC2_SG);
                            textView31.setText(PP_QC2_SG);

                            textView32 = (TextView) getView().findViewById(R.id.PP_QC3_DID);
                            textView32.setText(PP_QC3_DID);
                            textView33 = (TextView) getView().findViewById(R.id.PP_QC3_PID);
                            textView33.setText(PP_QC3_PID);
                            textView34 = (TextView) getView().findViewById(R.id.PP_QC3_CNT);
                            textView34.setText(PP_QC3_CNT);
                            textView35 = (TextView) getView().findViewById(R.id.PP_QC3_SG);
                            textView35.setText(PP_QC3_SG);

                            textView36 = (TextView) getView().findViewById(R.id.PP_QD1_DID);
                            textView36.setText(PP_QD1_DID);
                            textView37 = (TextView) getView().findViewById(R.id.PP_QD1_PID);
                            textView37.setText(PP_QD1_PID);
                            textView38 = (TextView) getView().findViewById(R.id.PP_QD1_CNT);
                            textView38.setText(PP_QD1_CNT);
                            textView39 = (TextView) getView().findViewById(R.id.PP_QD1_SG);
                            textView39.setText(PP_QD1_SG);

                            textView40 = (TextView) getView().findViewById(R.id.PP_QD2_DID);
                            textView40.setText(PP_QD2_DID);
                            textView41 = (TextView) getView().findViewById(R.id.PP_QD2_PID);
                            textView41.setText(PP_QD2_PID);
                            textView42 = (TextView) getView().findViewById(R.id.PP_QD2_CNT);
                            textView42.setText(PP_QD2_CNT);
                            textView43 = (TextView) getView().findViewById(R.id.PP_QD2_SG);
                            textView43.setText(PP_QD2_SG);

                            textView44 = (TextView) getView().findViewById(R.id.PP_QD3_DID);
                            textView44.setText(PP_QD3_DID);
                            textView45 = (TextView) getView().findViewById(R.id.PP_QD3_PID);
                            textView45.setText(PP_QD3_PID);
                            textView46 = (TextView) getView().findViewById(R.id.PP_QD3_CNT);
                            textView46.setText(PP_QD3_CNT);
                            textView47 = (TextView) getView().findViewById(R.id.PP_QD3_SG);
                            textView47.setText(PP_QD3_SG);

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
