package com.example.santiagolopezgarcia.pruebarappi.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.santiagolopezgarcia.pruebarappi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by ronaldgallegoduque on 3/07/16.
 */
public class SplashActivity extends AppCompatActivity {

    @InjectView(R.id.lyMain)
    LinearLayout lyMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);

        if(getResources().getBoolean(R.bool.isTablet)){
            lyMain.setBackgroundResource(R.drawable.ic_tablet_splash);
        }else {
            lyMain.setBackgroundResource(R.drawable.ic_smatphone_splash);
        }

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
