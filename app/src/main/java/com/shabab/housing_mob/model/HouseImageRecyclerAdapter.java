package com.shabab.housing_mob.model;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.shabab.housing_mob.HouseActivity;
import com.shabab.housing_mob.HouseImageActivity;
import com.shabab.housing_mob.R;
import com.shabab.housing_mob.services.Services;

import java.util.List;


public class HouseImageRecyclerAdapter extends RecyclerView.Adapter<HouseImagesViewHolder> {
    private List<HouseImage> houseImagesList;
    private HouseImageActivity mContext;
    int heightSize;
    RecyclerView recyclerView;
    public HouseImageRecyclerAdapter(HouseImageActivity context, List<HouseImage> feedItemList) {
        this.houseImagesList = feedItemList;
        this.mContext = context;


        //Log.e   ("const adapter","");
    }

 /*   @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       // View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null);
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, parent, false);



        CustomViewHolder viewHolder = new CustomViewHolder(view,heightSize);
        Log.e   ("CustomViewHolder adapter","");
        return viewHolder;
    }*/
    @Override
    public HouseImagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.house_image_row, parent, false);


        return new HouseImagesViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final HouseImagesViewHolder viewHolder, final int i) {
        final HouseImage houseImage = houseImagesList.get(i);


        String urlImage= Services.IMAGEURL+houseImage.getCounter()+'/'+houseImage.getImageId();


        Glide.with(mContext).load(urlImage)
                .thumbnail(0.5f)
                .crossFade()
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.imageView);



    }


    @Override
    public int getItemCount() {


        return  houseImagesList.size() ;
    }


}
