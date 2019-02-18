package com.cabalabs.iucaa_x;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    public Context mContext ;
    public List<Summary> mData ;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<Summary> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.summary_row_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, FragActivity.class);
                i.putExtra("UID",mData.get(viewHolder.getAdapterPosition()).getUID());
                i.putExtra("folder",mData.get(viewHolder.getAdapterPosition()).getFolder());
                i.putExtra("OBSID",mData.get(viewHolder.getAdapterPosition()).getOBSID());
                i.putExtra("Observer",mData.get(viewHolder.getAdapterPosition()).getObserver());
                i.putExtra("Object",mData.get(viewHolder.getAdapterPosition()).getObject());
                i.putExtra("RA",mData.get(viewHolder.getAdapterPosition()).getRA());
                i.putExtra("Decr",mData.get(viewHolder.getAdapterPosition()).getDecr());
                i.putExtra("Exposure_time",mData.get(viewHolder.getAdapterPosition()).getExposure_time());

                mContext.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.folder.setText(mData.get(position).getFolder());
        holder.observer.setText(mData.get(position).getObserver());

        // Load Image from the internet and set it into Imageview using Glide

        //Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView folder ;
        TextView observer ;
        //ImageView img_thumbnail;
        LinearLayout view_container;


        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            folder = itemView.findViewById(R.id.folder);
            observer = itemView.findViewById(R.id.observer);
            //img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }
}