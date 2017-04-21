package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jitendra.tourism.R;

import java.io.File;
import java.util.ArrayList;

public class Activity3_b_AddPlace extends AppCompatActivity {

    private ImageView Add_CityImage;
    private TextView Add_CityName;
    private Button Save;
    private String CityName;
    private ArrayList<String> file_Path=new ArrayList<String>();
    private File[] listFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_b__add_place);
        getFromSdcard();

        Add_CityImage=(ImageView) findViewById(R.id.iv_AddCityImage);
        Add_CityName=(TextView) findViewById(R.id.tv_AddCityName);
        Save=(Button)findViewById(R.id.b_Save);

        CityName=Add_CityName.getText().toString();

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity3_GridView Act=new Activity3_GridView();
                Bitmap bitmap = BitmapFactory.decodeFile(file_Path.get(0));
                Add_CityImage.setImageBitmap(bitmap);
                Act.Name=CityName;
                Act.file_PathFor_LocalPlace=file_Path;

            }
        });

    }

    public String getName(){return CityName;}

    public void getFromSdcard()
    {
        File file= new File(android.os.Environment.getExternalStorageDirectory(),"Pic");

        if (file.isDirectory())
        {
            listFile = file.listFiles();


            for (int i = 0; i < listFile.length; i++)
            {

                file_Path.add(listFile[i].getAbsolutePath());

            }
        }
    }
}
