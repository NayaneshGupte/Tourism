
//class for Cardview

package com.example.jitendra.tourism.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.adapter.PlacesAdapter;
import com.example.jitendra.tourism.model.Places;
import com.example.jitendra.tourism.utils.RecyclerViewItemClickListener;

import java.io.File;
import java.util.ArrayList;

public class Activity5aFamousPlaces extends AppCompatActivity implements RecyclerViewItemClickListener {

    private static final int REQUEST_CAMERA = 1;
    private static final int SELECT_FILE = 2;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PlacesAdapter placesAdapter;
    private ArrayList<String> filePath = new ArrayList<String>();// list of file paths
    private ArrayList<String> filePathToSend=new ArrayList<>();
    private File[] listFile;

    //String array to retrive name and details of places from string xml file
    String[] name, detail;

    //arraylist to bind up all class variables
    ArrayList<Places> placesList = new ArrayList<Places>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getFromSdcard();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityfamousplacescardview);

        recyclerView = (RecyclerView) findViewById(R.id.rv_famous_places_card);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        //getting name and details of city from resource file
        name = getResources().getStringArray(R.array.City_Name);
        detail = getResources().getStringArray(R.array.City_Discription);

        //loop for writing data to array list
        for (int i = (position * 4); i <= (position * 4) + 3; i++) {

            Places places = new Places(name[i], detail[i]);
            placesList.add(places);
            filePathToSend.add(filePath.get(i));
        }


        placesAdapter = new PlacesAdapter(placesList,filePathToSend);
        placesAdapter.setOnRecycleView_ItemClickListener(this);
        recyclerView.setAdapter(placesAdapter);

    }

    @Override
    public void onItemClick() {



        final CharSequence[] items = {"Take Photo", "Choose from Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                if (items[i].equals("Take Photo")) {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[i].equals("Choose from Gallery")) {

                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent,SELECT_FILE);
                }
            }
        });
        builder.show();

    }

    public void getFromSdcard()
    {
        File file= new File(android.os.Environment.getExternalStorageDirectory(),"CardView");

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
