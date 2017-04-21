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

import java.util.ArrayList;

public class Activity4CityDiscription extends AppCompatActivity {

    private ImageView Iv_CityPic;
    private TextView Tv_City_Discription;
    private Button B_Gallery;
    private Button B_FamousPlaces;
    private String[] City_Details;

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
        Intent intent= getIntent();
        final int Position = intent.getIntExtra("CityNumber", -1);
        final ArrayList<String> file_Path=intent.getStringArrayListExtra("Path");

        //setting images and text to their respective places

        Bitmap bitmap = BitmapFactory.decodeFile(file_Path.get(Position));
        Iv_CityPic.setImageBitmap(bitmap);
        Tv_City_Discription.setText(City_Details[Position]);


        B_Gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4CityDiscription.this,Activity5bGallery.class);
                intent.putExtra("position", Position);
                startActivity(intent);

            }
        });

        B_FamousPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4CityDiscription.this, Activity5aFamousPlaces.class);
                intent.putExtra("position", Position);
                startActivity(intent);
            }
        });




    }
}
