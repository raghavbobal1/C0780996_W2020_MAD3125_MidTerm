package com.king.c0780996_w2020_mad3125_midterm.user_interface;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.king.c0780996_w2020_mad3125_midterm.R;

public class SplashScreen extends AppCompatActivity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               // Intent intent=new Intent(SplashScreen.this, PersonInformationEntryActivity.class);
               // startActivity(intent);
                finish();
            }
        },0000);  //Change after testing

    }

}
