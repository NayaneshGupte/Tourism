
//splash screen of app

package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.jitendra.tourism.R;

public class Activity1SplashScreen extends AppCompatActivity {

    private ImageView mLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);

        mLogo =(ImageView) findViewById(R.id.iv_Logo);

        //setting onclicklistener to logo.clicking logo will take user to login screen

        mLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent=new Intent(Activity1SplashScreen.this,Activity2Login.class);
                startActivity(intent);
            }
        });
    }
}
