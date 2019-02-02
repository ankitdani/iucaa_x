package com.cabalabs.iucaa_x;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary2);

        // hide the default actionbar
        getSupportActionBar().hide();

        // Recieve data

        String folder  = getIntent().getExtras().getString("folder");
        String observer = getIntent().getExtras().getString("Observer");
        String OBSID = getIntent().getExtras().getString("OBSID");
        String Object  = getIntent().getExtras().getString("Object");
        String RA = getIntent().getExtras().getString("RA");
        String Decr = getIntent().getExtras().getString("Decr");
        String Exposure_time = getIntent().getExtras().getString("Exposure_time");

        Log.e("TEST", folder);
        //Log.e("TEST1", observer);

        // ini views

        TextView textView = findViewById(R.id.showtext);
        textView.setText(folder);

        TextView textView2 = findViewById(R.id.showtext2);
        textView2.setText(observer);

        TextView textView3 = findViewById(R.id.showtext3);
        textView3.setText(OBSID);

        TextView textView4 = findViewById(R.id.showtext4);
        textView4.setText(Object);

        TextView textView5 = findViewById(R.id.showtext5);
        textView5.setText(RA);

        TextView textView6 = findViewById(R.id.showtext6);
        textView6.setText(Decr);

        TextView textView7 = findViewById(R.id.showtext7);
        textView7.setText(Exposure_time);


//
//        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
//        collapsingToolbarLayout.setTitleEnabled(true);
//
//        TextView tv_name = findViewById(R.id.aa_anime_name);
//        TextView tv_studio = findViewById(R.id.aa_studio);
//        TextView tv_categorie = findViewById(R.id.aa_categorie) ;
//        TextView tv_description = findViewById(R.id.aa_description);
//        TextView tv_rating  = findViewById(R.id.aa_rating) ;
//        ImageView img = findViewById(R.id.aa_thumbnail);
//
//        // setting values to each view
//
//        tv_name.setText(name);
//        tv_categorie.setText(category);
//        tv_description.setText(description);
//        tv_rating.setText(rating);
//        tv_studio.setText(studio);
//
//        collapsingToolbarLayout.setTitle(name);
//
//
//        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
//
//
//        // set image using Glide
//        Glide.with(this).load(image_url).apply(requestOptions).into(img);





    }
}