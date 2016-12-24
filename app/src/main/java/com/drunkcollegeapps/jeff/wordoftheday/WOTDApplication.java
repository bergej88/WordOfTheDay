package com.drunkcollegeapps.jeff.wordoftheday;

import android.app.Application;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * IMPORTANT:
 * This class is referenced in the manifest file so that it can be accessed throughout the application!
 */
public class WOTDApplication extends Application {

    public static final String TAG = WOTDApplication.class.getSimpleName();
    private RequestQueue mRequestQueue;

    private static WOTDApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized WOTDApplication getInstance() {
        return mInstance;
    }

    // Returns a references to the current request queue or creates a new one for first request
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    // Put the request into the queue associated to the proper tag
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    // Put the request into the queue associated to the CCApplication Tag
    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    // Shut down pending requests
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }


}
