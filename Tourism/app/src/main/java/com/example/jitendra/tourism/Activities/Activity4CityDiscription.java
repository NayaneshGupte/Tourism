package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitendra.tourism.R;

public class Activity4CityDiscription extends AppCompatActivity {

    private ImageView ivCityPic;
    private TextView tvCityDiscription;
    private Button bGallery;
    private Button bFamousPlaces;
    private String[] cityDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitycitydiscription);

        //assigning layout items to variables
        ivCityPic =(ImageView) findViewById(R.id.iv_CityPic);
        tvCityDiscription =(TextView) findViewById(R.id.tv_CityDiscription);
        bGallery =(Button)findViewById(R.id.b_gallery);
        bFamousPlaces =(Button)findViewById(R.id.b_FamousPlaces);

        //getting city details from resource xml file
        cityDetails =getResources().getStringArray(R.array.citydetails);

        //getting position from intent of previous activity
        Intent intent= getIntent();
        final int Position = intent.getIntExtra("CityNumber", -1);


        //setting images and text to their respective places

        Bitmap bitmap = BitmapFactory.decodeByteArray(intent.getByteArrayExtra("byte Array"),0,intent.getByteArrayExtra("byte Array").length);
        ivCityPic.setImageBitmap(bitmap);
        tvCityDiscription.setText(cityDetails[Position]);


        bGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4CityDiscription.this,Activity5bGallery.class);
                intent.putExtra("position", Position);
                startActivity(intent);

            }
        });

        bFamousPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4CityDiscription.this, Activity5aFamousPlaces.class);
                intent.putExtra("position", Position);
                startActivity(intent);
            }
        });




    }
}
