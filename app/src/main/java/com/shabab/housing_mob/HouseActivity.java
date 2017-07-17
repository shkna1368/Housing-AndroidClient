package com.shabab.housing_mob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.shabab.housing_mob.services.GetHousesServise;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

public class HouseActivity extends Activity  {

    GetHousesServise housesServise;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houses);
recyclerView= (RecyclerView) findViewById(R.id.recyclerView);






        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);


         housesServise=new GetHousesServise(this,recyclerView);
        callHouseWebService();

    }
    void callHouseWebService(){
        try {
            housesServise.getHouses();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
