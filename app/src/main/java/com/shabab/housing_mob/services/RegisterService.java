package com.shabab.housing_mob.services;

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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.shabab.housing_mob.RegisterActivity;
import com.shabab.housing_mob.app.AppController;
import com.shabab.housing_mob.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by Sh-Java on 11/10/2016.
 */
public class RegisterService {
    RegisterActivity ctx;


    public RegisterService(RegisterActivity ctx) {
        this.ctx = ctx;
    }

    public   void sendToServer(User user) throws JSONException, UnsupportedEncodingException {
        //   http://192.168.1.2:9080/Datasnap/rest/TserverMethods/AddToRecipt/21/1/5/  [{"stuffCode":1001,"entity":1,"unitSellPrice":3,"discount":3,"deficitValue":8,"taxValue":10}, {"stuffCode":1002,"entity":12,"unitSellPrice":40,"discount":32,"deficitValue":5,"taxValue":15}]


        String    urlRegister= Services.REGISTER;
           int reqType=   Request.Method.POST;






        JSONObject jsonobject_one = new JSONObject();
        try {
            jsonobject_one.put("name",user.getName());
            jsonobject_one.put("city",user.getCity());
            jsonobject_one.put("phone",user.getPhone());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq=null;

        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        jsonObjReq = new JsonObjectRequest(reqType,
                urlRegister,jsonobject_one,
                new Response.Listener<JSONObject>() {




                    @Override
                    public void onResponse(JSONObject response) {




                        if (response!=null){


                            try {
                                parseJson(response);
                            } catch (JSONException e) {

                                e.printStackTrace();
                            }

                        }





                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();




               // context.finish();



                // pDialog.hide();
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
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

        };




        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                12000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Log.e("Body",new String(jsonObjReq.getBody(), "UTF-8"));
        String tag_json_arry = "json_array_req";
// Adding request to request queue
        // mRequestQueue.add(jsonObjReq);
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_arry);





    }
    public void parseJson(JSONObject response) throws JSONException {

      boolean res=  response.getBoolean("result");

        if(res) {
            long id=response.getLong("id");
            Toast.makeText(ctx, response.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(ctx, "User Register with ID="+id, Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ctx, "User Not Register ", Toast.LENGTH_LONG).show();

        }

    }


}