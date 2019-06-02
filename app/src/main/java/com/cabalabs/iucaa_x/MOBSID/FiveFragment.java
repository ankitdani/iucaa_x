package com.cabalabs.iucaa_x.MOBSID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

import uk.co.senab.photoview.PhotoViewAttacher;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class FiveFragment extends Fragment{

    public FiveFragment() {
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

    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getActivity().setRequestedOrientation(
//                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        URL = getString(R.string.mg_IP_NDF);
        jsonimagerequest();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_five, container, false);
    }

    private void jsonimagerequest() {

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

                            String qa_1 = jsonObject.getString("QA_S1B");
                            String qa_2 = jsonObject.getString("QA_B0C");
                            String qa_3 = jsonObject.getString("QA_B2KC");
                            String qa_4 = jsonObject.getString("QA_HRB");
                            String qa_5 = jsonObject.getString("QA_NTT");
                            String qa_6 = jsonObject.getString("QA_NDT");

                            String qb_1 = jsonObject.getString("QB_S1B");
                            String qb_2 = jsonObject.getString("QB_B0C");
                            String qb_3 = jsonObject.getString("QB_B2KC");
                            String qb_4 = jsonObject.getString("QB_HRB");
                            String qb_5 = jsonObject.getString("QB_NTT");
                            String qb_6 = jsonObject.getString("QB_NDT");

                            String qc_1 = jsonObject.getString("QC_S1B");
                            String qc_2 = jsonObject.getString("QC_B0C");
                            String qc_3 = jsonObject.getString("QC_B2KC");
                            String qc_4 = jsonObject.getString("QC_HRB");
                            String qc_5 = jsonObject.getString("QC_NTT");
                            String qc_6 = jsonObject.getString("QC_NDT");

                            String qd_1 = jsonObject.getString("QD_S1B");
                            String qd_2 = jsonObject.getString("QD_B0C");
                            String qd_3 = jsonObject.getString("QD_B2KC");
                            String qd_4 = jsonObject.getString("QD_HRB");
                            String qd_5 = jsonObject.getString("QD_NTT");
                            String qd_6 = jsonObject.getString("QD_NDT");

                            textView = (TextView) getView().findViewById(R.id.qa_1);
                            textView.setText(qa_1);
                            textView1 = (TextView) getView().findViewById(R.id.qa_2);
                            textView1.setText(qa_2);
                            textView2 = (TextView) getView().findViewById(R.id.qa_3);
                            textView2.setText(qa_3);
                            textView3 = (TextView) getView().findViewById(R.id.qa_4);
                            textView3.setText(qa_4);
                            textView4 = (TextView) getView().findViewById(R.id.qa_5);
                            textView4.setText(qa_5);
                            textView5 = (TextView) getView().findViewById(R.id.qa_6);
                            textView5.setText(qa_6);
                            textView6 = (TextView) getView().findViewById(R.id.qb_1);
                            textView6.setText(qb_1);
                            textView7 = (TextView) getView().findViewById(R.id.qb_2);
                            textView7.setText(qb_2);
                            textView8 = (TextView) getView().findViewById(R.id.qb_3);
                            textView8.setText(qb_3);
                            textView9 = (TextView) getView().findViewById(R.id.qb_4);
                            textView9.setText(qb_4);
                            textView10 = (TextView) getView().findViewById(R.id.qb_5);
                            textView10.setText(qb_5);
                            textView11 = (TextView) getView().findViewById(R.id.qb_6);
                            textView11.setText(qb_6);
                            textView12 = (TextView) getView().findViewById(R.id.qc_1);
                            textView12.setText(qc_1);
                            textView13 = (TextView) getView().findViewById(R.id.qc_2);
                            textView13.setText(qc_2);
                            textView14 = (TextView) getView().findViewById(R.id.qc_3);
                            textView14.setText(qc_3);
                            textView15 = (TextView) getView().findViewById(R.id.qc_4);
                            textView15.setText(qc_4);
                            textView16 = (TextView) getView().findViewById(R.id.qc_5);
                            textView16.setText(qc_5);
                            textView17 = (TextView) getView().findViewById(R.id.qc_6);
                            textView17.setText(qc_6);
                            textView18 = (TextView) getView().findViewById(R.id.qd_1);
                            textView18.setText(qd_1);
                            textView19 = (TextView) getView().findViewById(R.id.qd_2);
                            textView19.setText(qd_2);
                            textView20 = (TextView) getView().findViewById(R.id.qd_3);
                            textView20.setText(qd_3);
                            textView21 = (TextView) getView().findViewById(R.id.qd_4);
                            textView21.setText(qd_4);
                            textView22 = (TextView) getView().findViewById(R.id.qd_5);
                            textView22.setText(qd_5);
                            textView23 = (TextView) getView().findViewById(R.id.qd_6);
                            textView23.setText(qd_6);

                            String img1 = jsonObject.getString("QA_MLC");
                            String img2 = jsonObject.getString("QB_MLC");
                            String img3 = jsonObject.getString("QC_MLC");
                            String img4 = jsonObject.getString("QD_MLC");

                            imageView = (ImageView) getView().findViewById(R.id.img1);
                            imageView1 = (ImageView) getView().findViewById(R.id.img2);
                            imageView2 = (ImageView) getView().findViewById(R.id.img3);
                            imageView3 = (ImageView) getView().findViewById(R.id.img4);


                            Glide.with(FiveFragment.this).load(img1).transition(withCrossFade(1500)).into(imageView);
                            Glide.with(FiveFragment.this).load(img2).transition(withCrossFade(1500)).into(imageView1);
                            Glide.with(FiveFragment.this).load(img3).transition(withCrossFade(1500)).into(imageView2);
                            Glide.with(FiveFragment.this).load(img4).transition(withCrossFade(1500)).into(imageView3);

                            PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);
                            photoView.update();
                            PhotoViewAttacher photoView1 = new PhotoViewAttacher(imageView1);
                            photoView1.update();
                            PhotoViewAttacher photoView2 = new PhotoViewAttacher(imageView2);
                            photoView2.update();
                            PhotoViewAttacher photoView3 = new PhotoViewAttacher(imageView3);
                            photoView3.update();

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
