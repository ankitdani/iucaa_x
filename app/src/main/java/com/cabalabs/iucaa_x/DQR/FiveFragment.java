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

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class FiveFragment extends Fragment{

    public FiveFragment() {
        // Required empty public constructor
    }


    String URL;
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

        URL = getString(R.string.IP_LightCurve);

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

                            String img1 = jsonObject.getString("quadAimg");
                            String img2 = jsonObject.getString("quadBimg");
                            String img3 = jsonObject.getString("quadCimg");
                            String img4 = jsonObject.getString("quadDimg");

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
