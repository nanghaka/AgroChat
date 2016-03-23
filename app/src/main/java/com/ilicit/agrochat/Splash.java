package com.ilicit.agrochat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Leinad on 11/3/2015.
 */

public class Splash extends Activity {
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        session = new SessionManager(this);

        Thread timer =new Thread(){
            public void run(){
                try {
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    switch (session.user_type){

                        case "none":
//                            Intent MainPage =new Intent(Splash.this,MainActivity.class);
                            Intent MainPage =new Intent(Splash.this,LoginActivity.class);
//                            Intent MainPage =new Intent(Splash.this,Dashboard.class);
                            startActivity(MainPage);
                            finish();
                            break;
//                        case "superAdmin":
//                            Intent superadmin = new Intent(Splash.this, AdminDashboard.class);
//                            startActivity(superadmin);
//                            finish();
//                            break;
//                        case "region":
//                            Intent regiondash = new Intent(Splash.this, RegionalDashboard.class);
//                            startActivity(regiondash);
//                            finish();
//                            break;
//                        case "distribution":
//                            Intent distriActivity = new Intent(Splash.this, DistributionDashboard.class);
//                            startActivity(distriActivity);
//                            finish();
//                            break;
//                        case "hospital":
//                            Intent hospitalDashboard = new Intent(Splash.this, com.joydan.ubts.hospitalspace.HospitalDashboard.class);
//                            startActivity(hospitalDashboard);
//                            finish();
//                            break;
                        default:
//                            Intent defActiv =new Intent(Splash.this,Dashboard.class);
                            Intent defActiv =new Intent(Splash.this,LoginActivity.class);
                            startActivity(defActiv);
                            finish();
                    }


                }
            }
        };
        timer.start();
    }

}
