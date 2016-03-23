package com.ilicit.agrochat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    public SharedPreferences pref;

    public Editor editor;
    public Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    public String userName;
    public String userId;
    public String regcenter_id;
    public String distrib_center_id;
    public String hospitalId;

    public String user_type;


    // Shared preferences file name
    public static final String PREF_NAME = "UBTS";

    public static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

        // USERNAME
        userName = pref.getString("userName", null);
        // USERID
        userId = pref.getString("userId", null);

        //Hospital ID
        hospitalId = pref.getString("hospitalId", null);

        //Indicator of the user role
        user_type = pref.getString("user_type", "none");

        // Regional Id
        regcenter_id = pref.getString("regcenter_id", null);

        // distribution ID
        distrib_center_id = pref.getString("distrib_center_id", null);
    }

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }
}
