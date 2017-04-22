
//GridView Of cities

package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.adapter.GridViewAdapter;
import com.example.jitendra.tourism.model.GridViewModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Activity3GridView extends AppCompatActivity {

    private GridView gridView;
    private ArrayList<String> filePath = new ArrayList<String>();// list of file paths
    ArrayList<String> filePathForLocalPlace = new ArrayList<String>();
    private ArrayList<GridViewModel> gridViewModels =new ArrayList<GridViewModel>();//here AL is defining ArrayList
    String nameOfLocalPlace;
    private File[] listFile;
    //Array to store City name
    private String[] cityName;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getFromSdcard();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        gridView = (GridView) findViewById(R.id.gv_GridView1);

        //initializing City name array with String array in source xml
        cityName = getResources().getStringArray(R.array.CityNames);


        for(int i = 0; i< cityName.length; i++){

            GridViewModel gridView_model =new GridViewModel(cityName[i]);
            gridViewModels.add(gridView_model);
        }
        //calling adapter class on gridview
        gridView.setAdapter(new GridViewAdapter(gridViewModels, filePath/*, nameOfLocalPlace, filePathForLocalPlace*/));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position!=8){

                    Intent intent = new Intent(Activity3GridView.this, Activity4CityDiscription.class);
                    intent.putExtra("CityNumber", position);
                    Log.e("TAG",String.valueOf(filePathForLocalPlace.size()));
                    Log.e("TAG",String.valueOf(nameOfLocalPlace==null));
                    Log.e("TAG",String.valueOf(filePathForLocalPlace.isEmpty()));
                    //converting bitmap to ByteArray
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath.get(position));
                    ByteArrayOutputStream bs=new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG,50,bs);
                    intent.putExtra("byte Array",bs.toByteArray());

                    startActivity(intent);
                }

                else{

                    Intent intent = new Intent(Activity3GridView.this, Activity3bAddPlace.class);
                    startActivity(intent);

                   /* *//*bundle=new Bundle();
                    bundle.putString("Name", nameOfLocalPlace);
                    bundle.putStringArrayList("Path", filePathForLocalPlace);*//*
                    GridViewModel gridViewModel=new GridViewModel("Kapur");
                    gridViewModels.set(position,gridViewModel);
                    filePath.set(position,filePathForLocalPlace.get(position));
                    GridViewAdapter adapter=new GridViewAdapter(gridViewModels, filePath*//*, nameOfLocalPlace, filePathForLocalPlace*//*);
                    *//*adapter.Receive_Data(bundle);*//*
                    gridView.setAdapter(adapter);*/

                }
            }
        });
    }

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
