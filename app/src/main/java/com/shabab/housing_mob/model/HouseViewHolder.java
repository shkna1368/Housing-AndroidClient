package com.shabab.housing_mob.model;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shabab.housing_mob.R;


public class HouseViewHolder extends RecyclerView.ViewHolder {




    public TextView city ;
    public TextView price ;
    public TextView area ;
    public TextView room ;



    public HouseViewHolder(View convertView ) {
        super(convertView);


        this. city= (TextView) convertView.findViewById(R.id.textCity);
        this. price=(TextView) convertView.findViewById(R.id.textPrice);
        this. area=(TextView) convertView.findViewById(R.id.textArea);
        this. room=(TextView) convertView.findViewById(R.id.textRoom);



    }
}
