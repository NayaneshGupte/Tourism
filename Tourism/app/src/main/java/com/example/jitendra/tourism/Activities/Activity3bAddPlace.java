package com.example.jitendra.tourism.Activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitendra.tourism.R;

import java.io.File;
import java.util.ArrayList;

public class Activity3bAddPlace extends AppCompatActivity {

    private ImageView addCityImage;
    private TextView addCityName;
    private Button save;
    private String cityName;
    private ArrayList<String> filePath =new ArrayList<String>();
    private File[] listFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_b__add_place);
        getFromSdcard();

        addCityImage =(ImageView) findViewById(R.id.iv_AddCityImage);
        addCityName =(TextView) findViewById(R.id.tv_AddCityName);
        save =(Button)findViewById(R.id.b_Save);

        cityName = addCityName.getText().toString();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity3GridView Act=new Activity3GridView();
                Bitmap bitmap = BitmapFactory.decodeFile(filePath.get(0));
                addCityImage.setImageBitmap(bitmap);
                Act.nameOfLocalPlace = cityName;
                Act.filePathForLocalPlace = filePath;

            }
        });

    }

    public String getName(){return cityName;}

    public void getFromSdcard()
    {
        File file= new File(android.os.Environment.getExternalStorageDirectory(),"Pic");

        if (file.isDirectory())
        {
            listFile = file.listFiles();


            for (int i = 0; i < listFile.length; i++)
            {

                filePath.add(listFile[i].getAbsolutePath());

            }
        }
    }
}
