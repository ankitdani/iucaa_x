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

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class EightFragment extends Fragment{

    public EightFragment() {
        // Required empty public constructor
    }


    final String URL = "http://192.168.43.12:8000/dqrreport/countrate";
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        jsonimagerequest();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eight, container, false);
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

                            String crplot1 = jsonObject.getString("crplot1");
                            String crimg1 = jsonObject.getString("crimg1");
                            String crplot2 = jsonObject.getString("crplot2");
                            String crimg2 = jsonObject.getString("crimg2");
                            String crplot3 = jsonObject.getString("crplot3");
                            String crimg3 = jsonObject.getString("crimg4");
                            String crplot4 = jsonObject.getString("crplot4");
                            String crimg4 = jsonObject.getString("crimg4");
                            String crplot5 = jsonObject.getString("crplot5");
                            String crimg5 = jsonObject.getString("crimg5");
                            String crplot6 = jsonObject.getString("crplot6");
                            String crimg6 = jsonObject.getString("crimg6");

                            imageView = (ImageView) getView().findViewById(R.id.img1);
                            imageView1 = (ImageView) getView().findViewById(R.id.img2);
                            imageView2 = (ImageView) getView().findViewById(R.id.img3);
                            imageView3 = (ImageView) getView().findViewById(R.id.img4);

                            imageView4 = (ImageView) getView().findViewById(R.id.img5);
                            imageView5 = (ImageView) getView().findViewById(R.id.img6);
                            imageView6 = (ImageView) getView().findViewById(R.id.img7);
                            imageView7 = (ImageView) getView().findViewById(R.id.img8);

                            imageView8 = (ImageView) getView().findViewById(R.id.img9);
                            imageView9 = (ImageView) getView().findViewById(R.id.img10);
                            imageView10 = (ImageView) getView().findViewById(R.id.img11);
                            imageView11 = (ImageView) getView().findViewById(R.id.img12);


                            Glide.with(EightFragment.this).load(crplot1).transition(withCrossFade(1500)).into(imageView);
                            Glide.with(EightFragment.this).load(crimg1).transition(withCrossFade(1500)).into(imageView1);
                            Glide.with(EightFragment.this).load(crplot2).transition(withCrossFade(1500)).into(imageView2);
                            Glide.with(EightFragment.this).load(crimg2).transition(withCrossFade(1500)).into(imageView3);
                            Glide.with(EightFragment.this).load(crplot3).transition(withCrossFade(1500)).into(imageView4);
                            Glide.with(EightFragment.this).load(crimg3).transition(withCrossFade(1500)).into(imageView5);
                            Glide.with(EightFragment.this).load(crplot4).transition(withCrossFade(1500)).into(imageView6);
                            Glide.with(EightFragment.this).load(crimg4).transition(withCrossFade(1500)).into(imageView7);
                            Glide.with(EightFragment.this).load(crplot5).transition(withCrossFade(1500)).into(imageView8);
                            Glide.with(EightFragment.this).load(crimg5).transition(withCrossFade(1500)).into(imageView9);
                            Glide.with(EightFragment.this).load(crplot6).transition(withCrossFade(1500)).into(imageView10);
                            Glide.with(EightFragment.this).load(crimg6).transition(withCrossFade(1500)).into(imageView11);

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
