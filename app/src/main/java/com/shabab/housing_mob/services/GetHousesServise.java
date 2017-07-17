package com.shabab.housing_mob.services;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;

import com.shabab.housing_mob.HouseActivity;
import com.shabab.housing_mob.app.AppController;
import com.shabab.housing_mob.model.House;
import com.shabab.housing_mob.model.HouseRecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;




public class GetHousesServise {

   public HouseActivity ctx;

    RecyclerView recyclerView;

    public GetHousesServise(HouseActivity ctx,RecyclerView recyclerView) {
        this.ctx =ctx;
this.recyclerView=recyclerView;
    }

    public   void getHouses() throws JSONException, UnsupportedEncodingException {
        //   http://192.168.1.2:9080/Datasnap/rest/TserverMethods/AddToRecipt/21/1/5/  [{"stuffCode":1001,"entity":1,"unitSellPrice":3,"discount":3,"deficitValue":8,"taxValue":10}, {"stuffCode":1002,"entity":12,"unitSellPrice":40,"discount":32,"deficitValue":5,"taxValue":15}]
        JSONArray obj = null  ;









        //this.factorBeanClass=factorBean;
      //  String   urlGetCategory= Services.getCategories+shopId+'/'+password;
        String   urlHouse= Services.GETHOUSES;
        Log.e("url houses****==", urlHouse) ;






        //Log.e("Location isssss",jsLoc.toString()) ;

        // Log.e("Json issss",json.toString()) ;




        JsonArrayRequest jsonObjReq=null;

        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        jsonObjReq = new JsonArrayRequest (Request.Method.GET,
                urlHouse,null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {




                        if (response!=null){


                            parseJson(response);
                        }





                    }
                    // pDialog.hide();

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             //   Toast.makeText(context, R.string.error_connect, Toast.LENGTH_SHORT).show();



                if ((error instanceof NetworkError) || (error instanceof NoConnectionError) ) {




                    Toast.makeText(ctx,"Network Error", Toast.LENGTH_SHORT).show();
                    // progressDialog.dismiss();
                    return;
                }
                if (error instanceof TimeoutError){


                    Toast.makeText(ctx, "TimeOut", Toast.LENGTH_SHORT).show();
                    // context.getDialog().dismiss();
                    return;
                }




                if ((error instanceof ServerError) || (error instanceof AuthFailureError)){

                    //  Toast.makeText(context, R.string.server_error, Toast.LENGTH_SHORT).show();
                    // context.getDialog().dismiss();






                    Toast.makeText(ctx, "ServerError", Toast.LENGTH_SHORT).show();
                    return;
                }







            }
        }

        )

        {
            public String getBodyContentType()
            {
                return "application/json";
            }




        };

        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                8000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Log.e("Body",new String(jsonObjReq.getBody(), "UTF-8"));
        String tag_json_arry = "json_array_req";
// Adding request to request queue
        // mRequestQueue.add(jsonObjReq);
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_arry);





    }
    public void parseJson(JSONArray response){
      List<House> houseList=new ArrayList<>();

        Log.e("Finito","size="+response.toString());


        for (int i = 0; i < response.length(); i++) {
            // JSONObject row = response.getJSONObject("result");;
            try {


               /* {
                    "houseId": 6,
                        "userId": 5,
                        "city": "تهران",
                        "homeAge": 5,
                        "lat": 35.335224,
                        "lon": 46.98995,
                        "room": 5,
                        "area": 70,
                        "price": 50000000,
                        "createDate": "Nov 9, 2016"
                },*/
                //   Contact c=new Contact();
                JSONObject c=(JSONObject) response.get(i);
                Log.e("objjj","ts="+c.toString());
                long userId=c.getLong("userId");

                long houseId=c.getLong("houseId");
                int houseAge=c.getInt("homeAge");
                int room=c.getInt("room");
                int area=c.getInt("area");
                int price=c.getInt("price");
                double lat=c.getLong("lat");
                long lon=c.getLong("lon");
                String  city=c.getString("city");



                House house=new House();
                house.setUserId(userId);
                house.setHouseId(houseId);
                house.setHomeAge(houseAge);
                house.setRoom(room);
                house.setCity(city);
                house.setArea(area);
                house.setPrice(price);
                house.setLat(lat);
                house.setLon(lon);




                houseList.add(i,house);










            } catch (JSONException e) {
                Log.e("error",e.toString());
                e.printStackTrace();

            }



        }
        HouseRecyclerAdapter adapter=new HouseRecyclerAdapter(ctx,houseList,recyclerView);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
       /* Collections.sort(categoryBeanParent);
        Collections.sort(categoryBeanLisAll);
        Util.allCategoryList=categoryBeanLisAll;
        Util.parentCategoryList=categoryBeanParent;
        CustomCategoryListAdapter adapter=new CustomCategoryListAdapter(context,categoryBeanParent);
        context.getListViewCategory().setAdapter(adapter);
        adapter.notifyDataSetChanged();
*/

        //context.getDialog().dismiss();
        Log.e("Finito","size="+houseList.size());
        Log.e("Finito","Finito");
    }

}
