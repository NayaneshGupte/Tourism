package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitendra.tourism.R;

public class Activity4_CityDiscription extends AppCompatActivity {

    private ImageView Iv_CityPic;
    private TextView Tv_City_Discription;
    private Button B_Gallery;
    private Button B_FamousPlaces;

    private String[] City_Details;


    private int[] City_Images={R.drawable.delhi,R.drawable.mumbai,R.drawable.chennai,R.drawable.kolkatta,R.drawable.lucknow,R.drawable.hyderabad,R.drawable.ahmdbd,R.drawable.bang};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city__discription);

        //assigning layout items to variables
        Iv_CityPic =(ImageView) findViewById(R.id.iv_CityPic);
        Tv_City_Discription =(TextView) findViewById(R.id.tv_CityDiscription);
        B_Gallery =(Button)findViewById(R.id.b_gallery);
        B_FamousPlaces =(Button)findViewById(R.id.b_FamousPlaces);

        //getting city details from resource xml file
        City_Details=getResources().getStringArray(R.array.citydetails);

        //getting position from intent of previous activity
        final int Pos = getIntent().getIntExtra("CityNumber", -1);

        //setting images and text to their respective places
        Iv_CityPic.setImageResource(City_Images[Pos]);
        Tv_City_Discription.setText(City_Details[Pos]);


        B_Gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4_CityDiscription.this,Activity5_b_Gallery.class);
                intent.putExtra("position", Pos);
                startActivity(intent);

            }
        });

        B_FamousPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4_CityDiscription.this, Activity5_a_FamousPlaces.class);
                intent.putExtra("position", Pos);
                startActivity(intent);
            }
        });




    }
}
