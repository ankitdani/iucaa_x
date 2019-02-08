package com.cabalabs.iucaa_x;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class dphActivity extends AppCompatActivity {

    final String URL = "http://192.168.2.12:8000/dqrreport/dph";
    JsonArrayRequest request;
    RequestQueue requestQueue;


      ImageView imageView;
      ImageView imageView1;
      ImageView imageView2;
      ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dph);

        jsonimagerequest();
    }

    private void jsonimagerequest() {

        request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = new JSONObject();

                for(int i=0; i<response.length(); i++){

                    try{

                        jsonObject = response.getJSONObject(i);

                        String uidprev = getIntent().getExtras().getString("UID");
                        Log.e("Received",String.valueOf(uidprev));

                        String uid = jsonObject.getString("UID");

                        if(uid.equals(uidprev)) {

                            String quadA = jsonObject.getString("quadA");
                            String quadB = jsonObject.getString("quadB");
                            String quadC = jsonObject.getString("quadC");
                            String quadD = jsonObject.getString("quadD");

                            imageView = (ImageView) findViewById(R.id.imgA);
                            imageView1 = (ImageView) findViewById(R.id.imgB);
                            imageView2 = (ImageView) findViewById(R.id.imgC);
                            imageView3 = (ImageView) findViewById(R.id.imgD);

                            Glide.with(dphActivity.this).load(quadA).into(imageView);
                            Glide.with(dphActivity.this).load(quadB).into(imageView1);
                            Glide.with(dphActivity.this).load(quadC).into(imageView2);
                            Glide.with(dphActivity.this).load(quadD).into(imageView3);

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

        requestQueue = Volley.newRequestQueue(dphActivity.this);
        requestQueue.add(request);
    }
}
