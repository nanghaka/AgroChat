package com.ilicit.agrochat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TextView;
import android.widget.Toast;

//import com.ilicit.agrochat.android.R;

/**
 * Created by NANGHAKA on 3/15/2016.
 */


public class Dashboard extends AppCompatActivity {

    Button Chatroom;
    Button AboutButton;

    LocationManager locationManager;
    String mprovider;

    Button btnShowLocation;

    // GPSTracker class
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        Chatroom = (Button) findViewById(R.id.chatrooms);
        AboutButton = (Button) findViewById(R.id.about_agroChat);

        Chatroom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Dashboard.this, MainActivity.class);
//                myIntent.putExtra("Regional Centers",0);
                startActivity(myIntent);
            }
        });

//        ------------------------------------------
        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // create class object
                gps = new GPSTracker(Dashboard.this);

                // check if GPS enabled
                if(gps.canGetLocation()){

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }

            }
        });

//        ---------------------------------------


//        Chatroom = (Button) findViewById(R.id.chatrooms);

        AboutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Dashboard.this, AboutActivity.class);
//                myIntent.putExtra("Regional Centers",0);
                startActivity(myIntent);
            }
        });



    }


}