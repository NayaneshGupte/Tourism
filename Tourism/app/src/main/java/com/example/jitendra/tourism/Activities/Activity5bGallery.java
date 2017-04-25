package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.adapter.SwipeAdapter;

import java.io.File;
import java.util.ArrayList;

public class Activity5bGallery extends AppCompatActivity {

    private ViewPager viewPager;
    private SwipeAdapter swipeAdapter;

    private ArrayList<String> filePath = new ArrayList<String>();// list of file paths
    private ArrayList<String> filePathToSend = new ArrayList<String>();
    private File[] listFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getFromSdcard();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitygallery);

        viewPager = (ViewPager) findViewById(R.id.vp_Gallery);

        Intent in = getIntent();
        int position = in.getIntExtra("position", 0);

        for(int i=(position*3);i<=((position*3)+2);i++){

            filePathToSend.add(filePath.get(i));

        }

        swipeAdapter =new SwipeAdapter(this,filePathToSend);
        viewPager.setAdapter(swipeAdapter);


    }

    public void getFromSdcard()
    {
        File file= new File(android.os.Environment.getExternalStorageDirectory(),"Gallery");

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
