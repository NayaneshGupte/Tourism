package com.example.jitendra.tourism.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitendra.tourism.Activities.Activity3_GridView;
import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.model.GridView_Model;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by jitendra on 19/04/2017.
 */

public class GridView_Adapter extends BaseAdapter {

    private ArrayList<GridView_Model> AL_GridView=new ArrayList<GridView_Model>();
    private ArrayList<String> file_Path=new ArrayList<String>();
    private ArrayList<String> file_PathFor_LocalPlace=new ArrayList<String>();
    private String Name;
    //constructor to initialize GridView ArrayLIst
    public GridView_Adapter(ArrayList<GridView_Model> AL_GridView,ArrayList<String> file_Path,String Name,ArrayList<String> file_PathFor_LocalPlace) {
        this.AL_GridView = AL_GridView;
        this.file_Path=file_Path;
        this.Name=Name;
        this.file_PathFor_LocalPlace=file_PathFor_LocalPlace;
    }

    public GridView_Adapter() {
    }

    public void Receive_Data(Bundle bundle){

        Name=bundle.getString("Name","");
        file_PathFor_LocalPlace=bundle.getStringArrayList("Path");

    }

    @Override
    public int getCount() {
        return AL_GridView.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cities, parent, false);

            holder = new ViewHolder();
            holder.bind(convertView);
            convertView.setTag(holder);
        }

        else {


            holder = (ViewHolder) convertView.getTag();
        }

        if(Name!=null && file_PathFor_LocalPlace!=null && position==8){

            holder.CityName.setText(Name);
            Log.e(TAG,String.valueOf(file_PathFor_LocalPlace.size()));
            Bitmap bitmap = BitmapFactory.decodeFile(file_PathFor_LocalPlace.get(0));
            holder.CityImage.setImageBitmap(bitmap);
            holder.CityImage.setImageBitmap(bitmap);

        }
        else {
            GridView_Model gridView_model = AL_GridView.get(position);
            Bitmap bitmap = BitmapFactory.decodeFile(file_Path.get(position));
            holder.CityImage.setImageBitmap(bitmap);
            holder.CityName.setText(gridView_model.getCity_Name());
        }


        return convertView;


    }


    class ViewHolder {

        ImageView CityImage;
        TextView CityName;

        void bind(View view) {

            CityImage = (ImageView) view.findViewById(R.id.iv_City);
            CityName = (TextView) view.findViewById(R.id.tv_CityName);
        }
    }




}


