package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.adapter.SwipeAdapter;
import com.example.jitendra.tourism.model.GalleryModel;

import java.util.ArrayList;

public class Activity5bGallery extends AppCompatActivity {

    private ViewPager viewPager;
    private SwipeAdapter swipeAdapter;

    private int[] imageResource = {R.drawable.vpdelhiakshardham, R.drawable.vpdelhilotus, R.drawable.vpdelhijamma, R.drawable.vpmumbaimarine, R.drawable.vpmumbaichowpatti, R.drawable.vpmumbailast, R.drawable.vpchennaiqueen, R.drawable.vpchennaimgm, R.drawable.vpchennaimarina, R.drawable.vpkolkatadurga, R.drawable.vpkolkatabook, R.drawable.vpkolkatabbd, R.drawable.vplucknowjaneshwer, R.drawable.vplucknowambedkar, R.drawable.vplucknowzoo, R.drawable.vphyderabadopera, R.drawable.vphyderabadananthgiri, R.drawable.vphyderabadapstate, R.drawable.vpahemadabadthor, R.drawable.vpahemedabadvastrapur, R.drawable.vpahemdabadkankaria, R.drawable.vpbangpalace, R.drawable.vpbanglal, R.drawable.vpbangtipu};
    private ArrayList<GalleryModel> galleryModelArrayList =new ArrayList<GalleryModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        viewPager = (ViewPager) findViewById(R.id.vp_Gallery);

        Intent in = getIntent();
        int position = in.getIntExtra("position", 0);

        for(int i=(position*3);i<=((position*3)+2);i++){

            GalleryModel g=new GalleryModel(imageResource[i]);
            galleryModelArrayList.add(g);
        }

        swipeAdapter =new SwipeAdapter(this, galleryModelArrayList);
        viewPager.setAdapter(swipeAdapter);


    }
}
