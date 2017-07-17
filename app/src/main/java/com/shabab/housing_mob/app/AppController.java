package com.shabab.housing_mob.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.Locale;


public class AppController extends Application {

	public static final String TAG = AppController.class.getSimpleName();

	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;

	private static AppController mInstance;

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;

	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		//setLocale();
	}


	public static synchronized AppController getInstance() {
		return mInstance;
	}

	public RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}

		return mRequestQueue;
	}


	public <T> void addToRequestQueue(Request<T> req, String tag) {
		// set the default tag if tag is empty
		req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
		getRequestQueue().add(req);
	}

	public <T> void addToRequestQueue(Request<T> req) {
		req.setTag(TAG);
		getRequestQueue().add(req);
	}

	public void cancelPendingRequests(Object tag) {
		if (mRequestQueue != null) {
			mRequestQueue.cancelAll(tag);
		}
	}

		//tring languageToLoad  = "en"; // your language
       /*  Locale locale = new Locale(languageToLoad);
         Locale.setDefault(locale);
         Configuration config = new Configuration();
         config.locale = locale;
         getBaseContext().getResources().updateConfiguration(config,
                 getBaseContext().getResources().getDisplayMetrics());

        */



}