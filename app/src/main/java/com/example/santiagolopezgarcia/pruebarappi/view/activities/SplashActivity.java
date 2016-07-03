package com.example.santiagolopezgarcia.pruebarappi.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.santiagolopezgarcia.pruebarappi.R;

/**
 * Created by ronaldgallegoduque on 3/07/16.
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashActivity.this, ApplicationsGridActivity.class));
                }
            }
        };
        timerThread.start();

    }


    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
