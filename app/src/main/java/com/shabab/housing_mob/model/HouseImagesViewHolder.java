package com.shabab.housing_mob.model;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shabab.housing_mob.R;


public class HouseImagesViewHolder extends RecyclerView.ViewHolder {


ImageView imageView;



    public HouseImagesViewHolder(View convertView ) {
        super(convertView);


        this. imageView= (ImageView) convertView.findViewById(R.id.img);




    }
}
