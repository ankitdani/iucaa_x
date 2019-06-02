package com.cabalabs.iucaa_x.MOBSID;

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

public class ThreeFragment extends Fragment{

    public ThreeFragment() {
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



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        URL = getString(R.string.mg_IP_L1);
        jsonrequest();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
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


                            String M91 = jsonObject.getString("M9_A_BD");
                            String M92 = jsonObject.getString("M9_A_TP");
                            String M93 = jsonObject.getString("M9_A_DP");
                            String M94 = jsonObject.getString("M9_B_BD");
                            String M95 = jsonObject.getString("M9_B_TP");
                            String M96 = jsonObject.getString("M9_B_DP");
                            String M97 = jsonObject.getString("M9_C_BD");
                            String M98 = jsonObject.getString("M9_C_TP");
                            String M99 = jsonObject.getString("M9_C_DP");
                            String M910 = jsonObject.getString("M9_D_BD");
                            String M911 = jsonObject.getString("M9_D_TP");
                            String M912 = jsonObject.getString("M9_D_DP");

                            String M01 = jsonObject.getString("M0_A_BD");
                            String M02 = jsonObject.getString("M0_A_TP");
                            String M03 = jsonObject.getString("M0_A_DP");
                            String M04 = jsonObject.getString("M0_B_BD");
                            String M05 = jsonObject.getString("M0_B_TP");
                            String M06 = jsonObject.getString("M0_B_DP");
                            String M07 = jsonObject.getString("M0_C_BD");
                            String M08 = jsonObject.getString("M0_C_TP");
                            String M09 = jsonObject.getString("M0_C_DP");
                            String M010 = jsonObject.getString("M0_D_BD");
                            String M011 = jsonObject.getString("M0_D_TP");
                            String M012 = jsonObject.getString("M0_D_DP");

                            String SS1 = jsonObject.getString("SS_A_BD");
                            String SS2 = jsonObject.getString("SS_A_TP");
                            String SS3 = jsonObject.getString("SS_A_DP");
                            String SS4 = jsonObject.getString("SS_B_BD");
                            String SS5 = jsonObject.getString("SS_B_TP");
                            String SS6 = jsonObject.getString("SS_B_DP");
                            String SS7 = jsonObject.getString("SS_C_BD");
                            String SS8 = jsonObject.getString("SS_C_TP");
                            String SS9 = jsonObject.getString("SS_C_DP");
                            String SS10 = jsonObject.getString("SS_D_BD");
                            String SS11 = jsonObject.getString("SS_D_TP");
                            String SS12 = jsonObject.getString("SS_D_DP");


                            textView = (TextView) getView().findViewById(R.id.M91);
                            textView.setText(M91);
                            textView1 = (TextView) getView().findViewById(R.id.M92);
                            textView1.setText(M92);
                            textView2 = (TextView) getView().findViewById(R.id.M93);
                            textView2.setText(M93);
                            textView3 = (TextView) getView().findViewById(R.id.M94);
                            textView3.setText(M94);
                            textView4 = (TextView) getView().findViewById(R.id.M95);
                            textView4.setText(M95);
                            textView5 = (TextView) getView().findViewById(R.id.M96);
                            textView5.setText(M96);
                            textView6 = (TextView) getView().findViewById(R.id.M97);
                            textView6.setText(M97);
                            textView7 = (TextView) getView().findViewById(R.id.M98);
                            textView7.setText(M98);
                            textView8 = (TextView) getView().findViewById(R.id.M99);
                            textView8.setText(M99);
                            textView9 = (TextView) getView().findViewById(R.id.M910);
                            textView9.setText(M910);
                            textView10 = (TextView) getView().findViewById(R.id.M911);
                            textView10.setText(M911);
                            textView11 = (TextView) getView().findViewById(R.id.M912);
                            textView11.setText(M912);

                            textView12 = (TextView) getView().findViewById(R.id.M01);
                            textView12.setText(M01);
                            textView13 = (TextView) getView().findViewById(R.id.M02);
                            textView13.setText(M02);
                            textView14 = (TextView) getView().findViewById(R.id.M03);
                            textView14.setText(M03);
                            textView15 = (TextView) getView().findViewById(R.id.M04);
                            textView15.setText(M04);
                            textView16 = (TextView) getView().findViewById(R.id.M05);
                            textView16.setText(M05);
                            textView17 = (TextView) getView().findViewById(R.id.M06);
                            textView17.setText(M06);
                            textView18 = (TextView) getView().findViewById(R.id.M07);
                            textView18.setText(M07);
                            textView19 = (TextView) getView().findViewById(R.id.M08);
                            textView19.setText(M08);
                            textView20 = (TextView) getView().findViewById(R.id.M09);
                            textView20.setText(M09);
                            textView21 = (TextView) getView().findViewById(R.id.M010);
                            textView21.setText(M010);
                            textView22 = (TextView) getView().findViewById(R.id.M011);
                            textView22.setText(M011);
                            textView23 = (TextView) getView().findViewById(R.id.M012);
                            textView23.setText(M012);

                            textView24 = (TextView) getView().findViewById(R.id.SS1);
                            textView24.setText(SS1);
                            textView25 = (TextView) getView().findViewById(R.id.SS2);
                            textView25.setText(SS2);
                            textView26 = (TextView) getView().findViewById(R.id.SS3);
                            textView26.setText(SS3);
                            textView27 = (TextView) getView().findViewById(R.id.SS4);
                            textView27.setText(SS4);
                            textView28 = (TextView) getView().findViewById(R.id.SS5);
                            textView28.setText(SS5);
                            textView29 = (TextView) getView().findViewById(R.id.SS6);
                            textView29.setText(SS6);
                            textView30 = (TextView) getView().findViewById(R.id.SS7);
                            textView30.setText(SS7);
                            textView31 = (TextView) getView().findViewById(R.id.SS8);
                            textView31.setText(SS8);
                            textView32 = (TextView) getView().findViewById(R.id.SS9);
                            textView32.setText(SS9);
                            textView33 = (TextView) getView().findViewById(R.id.SS10);
                            textView33.setText(SS10);
                            textView34 = (TextView) getView().findViewById(R.id.SS11);
                            textView34.setText(SS11);
                            textView35 = (TextView) getView().findViewById(R.id.SS12);
                            textView35.setText(SS12);

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