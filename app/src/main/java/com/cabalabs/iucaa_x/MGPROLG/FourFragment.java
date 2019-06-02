package com.cabalabs.iucaa_x.MGPROLG;

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

public class FourFragment extends Fragment{

    public FourFragment() {
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        URL = getString(R.string.IP_DS);
        jsonrequest();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_four, container, false);
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


                            String qa1 = jsonObject.getString("QA_TS");
                            String qa2 = jsonObject.getString("QA_SS");
                            String qa3 = jsonObject.getString("QA_SP");
                            String qb1 = jsonObject.getString("QB_TS");
                            String qb2 = jsonObject.getString("QB_SS");
                            String qb3 = jsonObject.getString("QB_SP");
                            String qc1 = jsonObject.getString("QC_TS");
                            String qc2 = jsonObject.getString("QC_SS");
                            String qc3 = jsonObject.getString("QC_SP");
                            String qd1 = jsonObject.getString("QD_TS");
                            String qd2 = jsonObject.getString("QD_SS");
                            String qd3 = jsonObject.getString("QD_SP");



                            textView = (TextView) getView().findViewById(R.id.qa1);
                            textView.setText(qa1);
                            textView1 = (TextView) getView().findViewById(R.id.qa2);
                            textView1.setText(qa2);
                            textView2 = (TextView) getView().findViewById(R.id.qa3);
                            textView2.setText(qa3);
                            textView3 = (TextView) getView().findViewById(R.id.qb1);
                            textView3.setText(qb1);
                            textView4 = (TextView) getView().findViewById(R.id.qb2);
                            textView4.setText(qb2);
                            textView5 = (TextView) getView().findViewById(R.id.qb3);
                            textView5.setText(qb3);
                            textView6 = (TextView) getView().findViewById(R.id.qc1);
                            textView6.setText(qc1);
                            textView7 = (TextView) getView().findViewById(R.id.qc2);
                            textView7.setText(qc2);
                            textView8 = (TextView) getView().findViewById(R.id.qc3);
                            textView8.setText(qc3);
                            textView9 = (TextView) getView().findViewById(R.id.qd1);
                            textView9.setText(qd1);
                            textView10 = (TextView) getView().findViewById(R.id.qd2);
                            textView10.setText(qd2);
                            textView11 = (TextView) getView().findViewById(R.id.qd3);
                            textView11.setText(qd3);

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
