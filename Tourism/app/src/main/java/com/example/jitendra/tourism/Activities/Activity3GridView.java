
//GridView Of cities

package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.adapter.GridViewAdapter;
import com.example.jitendra.tourism.model.GridViewModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

public class Activity3GridView extends AppCompatActivity {

    private static int Pos;//to keep track of position when activity is restarting
    private GridView gridView;
    private ArrayList<String> filePath = new ArrayList<String>();// list of file paths
    ArrayList<String> filePathForLocalPlace = new ArrayList<String>();
    private ArrayList<GridViewModel> gridViewModels = new ArrayList<GridViewModel>();//here AL is defining ArrayList
    String nameOfLocalPlace;
    private File[] listFile;
    //Array to store City name
    private String[] cityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getFromSdcard();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitycities);

        gridView = (GridView) findViewById(R.id.gv_GridView1);

        //initializing City name array with String array in source xml
        cityName = getResources().getStringArray(R.array.CityNames);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            nameOfLocalPlace = extras.getString("Name");
            filePathForLocalPlace = extras.getStringArrayList("Path");

        }

        for (int i = 0; i < cityName.length; i++) {

            GridViewModel gridView_model = new GridViewModel(cityName[i]);
            gridViewModels.add(gridView_model);
        }
        //initializing adapter variable
        GridViewAdapter adapter = new GridViewAdapter(gridViewModels, filePath);

        //checking credentials for Added Places
        if (nameOfLocalPlace != null && filePathForLocalPlace != null) {

            //Adding new values to grid view
            GridViewModel gridViewModel = new GridViewModel(nameOfLocalPlace);
            gridViewModels.remove(Pos);
            gridViewModels.add(Pos, gridViewModel);
            filePath.remove(Pos);
            filePath.add(Pos, filePathForLocalPlace.get(0));
            adapter.notifyDataSetChanged();
        }

        //calling adapter class on gridview
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 8) {
                    Pos = position;//storing position in Pos
                    //calling AddPlace Activity
                    Intent intent = new Intent(Activity3GridView.this, Activity3bAddPlace.class);
                    startActivity(intent);
                } else if (position != 8) {

                    Intent intent = new Intent(Activity3GridView.this, Activity4CityDiscription.class);
                    intent.putExtra("CityNumber", position);
                    //converting bitmap to ByteArray
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath.get(position));
                    ByteArrayOutputStream bs = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 50, bs);
                    intent.putExtra("byte Array", bs.toByteArray());

                    startActivity(intent);
                }
            }
        });
    }

    public void getFromSdcard() {
        File file = new File(android.os.Environment.getExternalStorageDirectory(), "GridView");

        if (file.isDirectory()) {
            listFile = file.listFiles();


            for (int i = 0; i < listFile.length; i++) {

                filePath.add(listFile[i].getAbsolutePath());

            }
        }
    }


}
