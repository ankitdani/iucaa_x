package com.cabalabs.iucaa_x.DQR;

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

public class QuadPropFragment extends Fragment{

    public QuadPropFragment() {
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

        URL = getString(R.string.IP_L1);
        jsonrequest();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quad_prop, container, false);
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

                            String QP_QA1_MN = jsonObject.getString("PP_QA1_DID");
                            String QP_QA1_MD = jsonObject.getString("PP_QA1_PID");
                            String QP_QA1_SG = jsonObject.getString("PP_QA1_SG");

                            String QP_QA2_MN = jsonObject.getString("PP_QA2_DID");
                            String QP_QA2_MD = jsonObject.getString("PP_QA2_PID");
                            String QP_QA2_SG = jsonObject.getString("PP_QA2_SG");

                            String QP_QA3_MN = jsonObject.getString("PP_QA3_DID");
                            String QP_QA3_MD = jsonObject.getString("PP_QA3_PID");
                            String QP_QA3_SG = jsonObject.getString("PP_QA3_SG");

                            String QP_QB1_MN = jsonObject.getString("PP_QB1_DID");
                            String QP_QB1_MD = jsonObject.getString("PP_QB1_PID");
                            String QP_QB1_SG = jsonObject.getString("PP_QB1_SG");

                            String QP_QB2_MN = jsonObject.getString("PP_QB2_DID");
                            String QP_QB2_MD = jsonObject.getString("PP_QB2_PID");
                            String QP_QB2_SG = jsonObject.getString("PP_QB2_SG");

                            String QP_QB3_MN = jsonObject.getString("PP_QB3_DID");
                            String QP_QB3_MD = jsonObject.getString("PP_QB3_PID");
                            String QP_QB3_SG = jsonObject.getString("PP_QB3_SG");

                            String QP_QC1_MN = jsonObject.getString("PP_QC1_DID");
                            String QP_QC1_MD = jsonObject.getString("PP_QC1_PID");
                            String QP_QC1_SG = jsonObject.getString("PP_QC1_SG");

                            String QP_QC2_MN = jsonObject.getString("PP_QC2_DID");
                            String QP_QC2_MD = jsonObject.getString("PP_QC2_PID");
                            String QP_QC2_SG = jsonObject.getString("PP_QC2_SG");

                            String QP_QC3_MN = jsonObject.getString("PP_QC3_DID");
                            String QP_QC3_MD = jsonObject.getString("PP_QC3_PID");
                            String QP_QC3_SG = jsonObject.getString("PP_QC3_SG");

                            String QP_QD1_MN = jsonObject.getString("PP_QD1_DID");
                            String QP_QD1_MD = jsonObject.getString("PP_QD1_PID");
                            String QP_QD1_SG = jsonObject.getString("PP_QD1_SG");

                            String QP_QD2_MN = jsonObject.getString("PP_QD2_DID");
                            String QP_QD2_MD = jsonObject.getString("PP_QD2_PID");
                            String QP_QD2_SG = jsonObject.getString("PP_QD2_SG");

                            String QP_QD3_MN = jsonObject.getString("PP_QD3_DID");
                            String QP_QD3_MD = jsonObject.getString("PP_QD3_PID");
                            String QP_QD3_SG = jsonObject.getString("PP_QD3_SG");


                            textView = (TextView) getView().findViewById(R.id.QP_QA1_MN);
                            textView.setText(QP_QA1_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QA1_MN);
                            textView.setText(QP_QA1_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QA1_MN);
                            textView.setText(QP_QA1_SG);

                            textView = (TextView) getView().findViewById(R.id.QP_QA2_MN);
                            textView.setText(QP_QA2_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QA2_MN);
                            textView.setText(QP_QA2_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QA2_MN);
                            textView.setText(QP_QA2_SG);

                            textView = (TextView) getView().findViewById(R.id.QP_QA3_MN);
                            textView.setText(QP_QA3_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QA3_MN);
                            textView.setText(QP_QA3_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QA3_MN);
                            textView.setText(QP_QA3_SG);

                            textView = (TextView) getView().findViewById(R.id.QP_QB1_MN);
                            textView.setText(QP_QB1_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QB1_MN);
                            textView.setText(QP_QB1_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QB1_MN);
                            textView.setText(QP_QB1_SG);

                            textView = (TextView) getView().findViewById(R.id.QP_QB2_MN);
                            textView.setText(QP_QB2_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QB2_MN);
                            textView.setText(QP_QB2_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QB2_MN);
                            textView.setText(QP_QB2_SG);

                            textView = (TextView) getView().findViewById(R.id.QP_QB3_MN);
                            textView.setText(QP_QB3_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QB3_MN);
                            textView.setText(QP_QB3_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QB3_MN);
                            textView.setText(QP_QB3_SG);

                            textView = (TextView) getView().findViewById(R.id.QP_QC1_MN);
                            textView.setText(QP_QC1_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QC1_MN);
                            textView.setText(QP_QC1_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QC1_MN);
                            textView.setText(QP_QC1_SG);

                            textView = (TextView) getView().findViewById(R.id.QP_QC2_MN);
                            textView.setText(QP_QC2_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QC2_MN);
                            textView.setText(QP_QC2_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QC2_MN);
                            textView.setText(QP_QC2_SG);

                            textView = (TextView) getView().findViewById(R.id.QP_QC3_MN);
                            textView.setText(QP_QC3_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QC3_MN);
                            textView.setText(QP_QC3_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QC3_MN);
                            textView.setText(QP_QC3_SG);

                            textView = (TextView) getView().findViewById(R.id.QP_QD1_MN);
                            textView.setText(QP_QD1_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QD1_MN);
                            textView.setText(QP_QD1_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QD1_MN);
                            textView.setText(QP_QD1_SG);

                            textView = (TextView) getView().findViewById(R.id.QP_QD2_MN);
                            textView.setText(QP_QD2_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QD2_MN);
                            textView.setText(QP_QD2_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QD2_MN);
                            textView.setText(QP_QD2_SG);

                            textView = (TextView) getView().findViewById(R.id.QP_QD3_MN);
                            textView.setText(QP_QD3_MN);
                            textView = (TextView) getView().findViewById(R.id.QP_QD3_MN);
                            textView.setText(QP_QD3_MD);
                            textView = (TextView) getView().findViewById(R.id.QP_QD3_MN);
                            textView.setText(QP_QD3_SG);

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
