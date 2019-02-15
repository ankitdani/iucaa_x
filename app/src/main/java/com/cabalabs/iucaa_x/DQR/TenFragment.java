package com.cabalabs.iucaa_x.DQR;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

public class TenFragment extends Fragment{

    public TenFragment() {
        // Required empty public constructor
    }


     String URL;
    JsonArrayRequest request;
    RequestQueue requestQueue;


    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        URL = getString(R.string.IP_HK);
        jsonimagerequest();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ten, container, false);
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

                            String plot1 = jsonObject.getString("plot1");
                            String plot2 = jsonObject.getString("plot2");
                            String plot3 = jsonObject.getString("plot3");
                            String plot4 = jsonObject.getString("plot4");
                            String plot5 = jsonObject.getString("plot5");
                            String plot6 = jsonObject.getString("plot6");
                            String plot7 = jsonObject.getString("plot7");
                            String plot8 = jsonObject.getString("plot8");
                            String plot9 = jsonObject.getString("plot9");
                            String plot10 = jsonObject.getString("plot10");
                            String plot11 = jsonObject.getString("plot11");
                            String plot12 = jsonObject.getString("plot12");
                            String plot13 = jsonObject.getString("plot13");
                            String plot14 = jsonObject.getString("plot14");

                            imageView = (ImageView) getView().findViewById(R.id.imgA);
                            imageView1 = (ImageView) getView().findViewById(R.id.imgB);
                            imageView2 = (ImageView) getView().findViewById(R.id.imgC);
                            imageView3 = (ImageView) getView().findViewById(R.id.imgD);

                            imageView4 = (ImageView) getView().findViewById(R.id.imgE);
                            imageView5 = (ImageView) getView().findViewById(R.id.imgF);
                            imageView6 = (ImageView) getView().findViewById(R.id.imgG);
                            imageView7 = (ImageView) getView().findViewById(R.id.imgH);

                            imageView8 = (ImageView) getView().findViewById(R.id.imgI);
                            imageView9 = (ImageView) getView().findViewById(R.id.imgJ);
                            imageView10 = (ImageView) getView().findViewById(R.id.imgK);
                            imageView11 = (ImageView) getView().findViewById(R.id.imgL);

                            imageView12 = (ImageView) getView().findViewById(R.id.imgM);
                            imageView13 = (ImageView) getView().findViewById(R.id.imgN);

                            Glide.with(TenFragment.this).load(plot1).transition(withCrossFade(1500)).into(imageView);
                            Glide.with(TenFragment.this).load(plot2).transition(withCrossFade(1500)).into(imageView1);
                            Glide.with(TenFragment.this).load(plot3).transition(withCrossFade(1500)).into(imageView2);
                            Glide.with(TenFragment.this).load(plot4).transition(withCrossFade(1500)).into(imageView3);

                            Glide.with(TenFragment.this).load(plot5).transition(withCrossFade(1500)).into(imageView4);
                            Glide.with(TenFragment.this).load(plot6).transition(withCrossFade(1500)).into(imageView5);
                            Glide.with(TenFragment.this).load(plot7).transition(withCrossFade(1500)).into(imageView6);
                            Glide.with(TenFragment.this).load(plot8).transition(withCrossFade(1500)).into(imageView7);

                            Glide.with(TenFragment.this).load(plot9).transition(withCrossFade(1500)).into(imageView8);
                            Glide.with(TenFragment.this).load(plot10).transition(withCrossFade(1500)).into(imageView9);
                            Glide.with(TenFragment.this).load(plot11).transition(withCrossFade(1500)).into(imageView10);
                            Glide.with(TenFragment.this).load(plot12).transition(withCrossFade(1500)).into(imageView11);

                            Glide.with(TenFragment.this).load(plot13).transition(withCrossFade(1500)).into(imageView12);
                            Glide.with(TenFragment.this).load(plot14).transition(withCrossFade(1500)).into(imageView13);


                            PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);
                            photoView.update();
                            PhotoViewAttacher photoView1 = new PhotoViewAttacher(imageView1);
                            photoView1.update();
                            PhotoViewAttacher photoView2 = new PhotoViewAttacher(imageView2);
                            photoView2.update();
                            PhotoViewAttacher photoView3 = new PhotoViewAttacher(imageView3);
                            photoView3.update();
                            PhotoViewAttacher photoView4 = new PhotoViewAttacher(imageView4);
                            photoView4.update();
                            PhotoViewAttacher photoView5 = new PhotoViewAttacher(imageView5);
                            photoView5.update();
                            PhotoViewAttacher photoView6 = new PhotoViewAttacher(imageView6);
                            photoView6.update();
                            PhotoViewAttacher photoView7 = new PhotoViewAttacher(imageView7);
                            photoView7.update();
                            PhotoViewAttacher photoView8 = new PhotoViewAttacher(imageView8);
                            photoView8.update();
                            PhotoViewAttacher photoView9 = new PhotoViewAttacher(imageView9);
                            photoView9.update();
                            PhotoViewAttacher photoView10 = new PhotoViewAttacher(imageView10);
                            photoView10.update();
                            PhotoViewAttacher photoView11 = new PhotoViewAttacher(imageView11);
                            photoView11.update();
                            PhotoViewAttacher photoView12 = new PhotoViewAttacher(imageView12);
                            photoView12.update();
                            PhotoViewAttacher photoView13 = new PhotoViewAttacher(imageView13);
                            photoView13.update();

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