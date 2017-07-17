package com.shabab.housing_mob.model;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.request.target.Target;

import com.shabab.housing_mob.HouseActivity;
import com.shabab.housing_mob.HouseImageActivity;
import com.shabab.housing_mob.R;

import java.util.List;


public class HouseRecyclerAdapter extends RecyclerView.Adapter<HouseViewHolder> {
    private List<House> houseList;
    private HouseActivity mContext;
    int heightSize;
    RecyclerView recyclerView;
    public HouseRecyclerAdapter(HouseActivity context, List<House> feedItemList,RecyclerView recyclerView) {
        this.houseList = feedItemList;
        this.mContext = context;
        this.recyclerView=recyclerView;
setListener();
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
    public HouseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.house_row, parent, false);


        return new HouseViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final HouseViewHolder viewHolder, final int i) {
        final House house = houseList.get(i);
        viewHolder.price.setText(house.getPrice()+"تومان");
        viewHolder.room.setText(house.getRoom()+" اتاق");
        viewHolder.area.setText(house.getArea()+"متر");
        viewHolder.city.setText(house.getCity());






    }
    public void setListener(){
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(mContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                  House h=  houseList.get(i);

                  Intent intent=new Intent(mContext, HouseImageActivity.class)  ;
                     //   intent.putExtra("houseId",h.getHouseId());
                        intent.putExtra("house",h);
                        mContext.startActivity(intent);

                    }
                })
        );


    }

    @Override
    public int getItemCount() {
        return (null != houseList ? houseList.size() : 0);
    }


}
