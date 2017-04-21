
//GridView Of cities

package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.adapter.GridViewAdapter;
import com.example.jitendra.tourism.model.GridViewModel;
import java.io.File;
import java.util.ArrayList;

public class Activity3GridView extends AppCompatActivity {

    private GridView Gridview;
    private ArrayList<String> file_Path = new ArrayList<String>();// list of file paths
    ArrayList<String> file_PathFor_LocalPlace = new ArrayList<String>();
    private ArrayList<GridViewModel> AL_GridView_model =new ArrayList<GridViewModel>();//here AL is defining ArrayList
    String Name_of_LocalPlace;
    private File[] listFile;
    //Array to store City name
    private String[] City_Name;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        getFromSdcard();

        Gridview = (GridView) findViewById(R.id.gv_GridView1);

        //initializing City name array with String array in source xml
        City_Name = getResources().getStringArray(R.array.CityNames);


        for(int i=0;i<City_Name.length;i++){

            GridViewModel gridView_model =new GridViewModel(City_Name[i]);
            AL_GridView_model.add(gridView_model);
        }
        //calling adapter class on gridview
        Gridview.setAdapter(new GridViewAdapter(AL_GridView_model,file_Path,Name_of_LocalPlace,file_PathFor_LocalPlace));


        Gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position!=8){

                    Intent intent = new Intent(Activity3GridView.this, Activity4CityDiscription.class);
                    /*intent.putExtra("CityNumber", position);
                    intent.putExtra("Path",file_Path[position]);*/
                    Bundle bundle=new Bundle();
                    bundle.putInt("Position",position);
                    bundle.putStringArrayList("Path",file_Path);
                    startActivity(intent);
                }

                else{

                    Intent intent = new Intent(Activity3GridView.this, Activity3bAddPlace.class);
                    startActivity(intent);
                    bundle=new Bundle();
                    bundle.putString("Name",Name_of_LocalPlace);
                    bundle.putStringArrayList("Path",file_PathFor_LocalPlace);

                    GridViewAdapter adapter=new GridViewAdapter(AL_GridView_model,file_Path,Name_of_LocalPlace,file_PathFor_LocalPlace);
                    adapter.Receive_Data(bundle);
                    Gridview.setAdapter(adapter);

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

                file_Path.add(listFile[i].getAbsolutePath());

            }
        }
    }


}
