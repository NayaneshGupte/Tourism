package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.jitendra.tourism.R;

import java.io.File;
import java.util.ArrayList;

public class Activity3bAddPlace extends AppCompatActivity {

    private ImageView addCityImage;
    private EditText addCityName;
    private Button save;
    private String nameOfLocalPlace;
    private ArrayList<String> filePathForLocalPlace = new ArrayList<String>();
    private File[] listFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3baddplace);
        getFromSdcard();

        //joining Activity with xml layout file
        addCityImage = (ImageView) findViewById(R.id.iv_AddCityImage);
        addCityName = (EditText) findViewById(R.id.tv_AddCityName);
        save = (Button) findViewById(R.id.b_Save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameOfLocalPlace = addCityName.getText().toString();
                Bitmap bitmap = BitmapFactory.decodeFile(filePathForLocalPlace.get(0));
                addCityImage.setImageBitmap(bitmap);

                Intent intent = new Intent(Activity3bAddPlace.this, Activity3GridView.class);
                intent.putExtra("Name", nameOfLocalPlace);
                intent.putExtra("Path", filePathForLocalPlace);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }


    public void getFromSdcard() {
        File file = new File(android.os.Environment.getExternalStorageDirectory(), "AddPlace");


        if (file.isDirectory()) {
            listFile = file.listFiles();


            for (int i = 0; i < listFile.length; i++) {

                filePathForLocalPlace.add(listFile[i].getAbsolutePath());

            }
        }
    }
}
