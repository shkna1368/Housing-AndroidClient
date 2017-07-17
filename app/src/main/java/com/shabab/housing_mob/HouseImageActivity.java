package com.shabab.housing_mob;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shabab.housing_mob.model.House;
import com.shabab.housing_mob.services.GetHousesImagesServise;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

public class HouseImageActivity extends Activity {
GetHousesImagesServise houseImagesService;
    TextView price, area, city, rooms;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houses_image);

        rooms = (TextView) findViewById(R.id.textView6);
        city = (TextView) findViewById(R.id.textView4);
        price = (TextView) findViewById(R.id.textView7);
        area = (TextView) findViewById(R.id.textView5);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        House h = (House) getIntent().getSerializableExtra("house");
        Log.e("houseID", h.getHouseId() + "");
        Log.e("homeRoom", h.getRoom() + "");

rooms.setText(h.getRoom()+"");
city.setText(h.getCity());
price.setText(h.getPrice()+"");
area.setText(h.getArea()+"");
        long houseId=h.getHouseId();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        houseImagesService=new GetHousesImagesServise(this,recyclerView);
        callImageWebService(houseId);

    }
    public void callImageWebService(long houseId){

        try {
            houseImagesService.getHouseImages(houseId);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}