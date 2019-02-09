package com.cabalabs.iucaa_x;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class SevenFragment extends Fragment{

    public SevenFragment() {
        // Required empty public constructor
    }


    final String URL = "http://192.168.2.12:8000/dqrreport/dph";
    JsonArrayRequest request;
    RequestQueue requestQueue;


    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        jsonimagerequest();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seven, container, false);
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

                            String quadA = jsonObject.getString("quadA");
                            String quadB = jsonObject.getString("quadB");
                            String quadC = jsonObject.getString("quadC");
                            String quadD = jsonObject.getString("quadD");

                            imageView = (ImageView) getView().findViewById(R.id.imgA);
                            imageView1 = (ImageView) getView().findViewById(R.id.imgB);
                            imageView2 = (ImageView) getView().findViewById(R.id.imgC);
                            imageView3 = (ImageView) getView().findViewById(R.id.imgD);

                            Glide.with(SevenFragment.this).load(quadA).into(imageView);
                            Glide.with(SevenFragment.this).load(quadB).into(imageView1);
                            Glide.with(SevenFragment.this).load(quadC).into(imageView2);
                            Glide.with(SevenFragment.this).load(quadD).into(imageView3);

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