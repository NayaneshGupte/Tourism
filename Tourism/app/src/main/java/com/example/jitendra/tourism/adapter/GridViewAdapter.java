package com.example.jitendra.tourism.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.model.GridViewModel;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by jitendra on 19/04/2017.
 */

public class GridViewAdapter extends BaseAdapter {

    private ArrayList<GridViewModel> alGridview =new ArrayList<GridViewModel>();
    private ArrayList<String> filePath =new ArrayList<String>();
    /*private ArrayList<String> filePathForLocalPlace =new ArrayList<String>();
    private String name;*/
    //constructor to initialize GridView ArrayLIst
    public GridViewAdapter(ArrayList<GridViewModel> alGridview, ArrayList<String> filePath/*, String Name, ArrayList<String> filePathForLocalPlace*/) {
        this.alGridview = alGridview;
        this.filePath = filePath;
        /*this.name=Name;
        this.filePathForLocalPlace = filePathForLocalPlace;*/
    }

    public GridViewAdapter() {
    }

    /*public void Receive_Data(Bundle bundle){

        name=bundle.getString("Name","");
        filePathForLocalPlace =bundle.getStringArrayList("Path");

    }*/

    @Override
    public int getCount() {
        return alGridview.size();
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

       /* if(filePathForLocalPlace !=null && position==8){

            holder.cityName.setText(name);
            Log.e(TAG,String.valueOf(filePathForLocalPlace.size()));
            Bitmap bitmap = BitmapFactory.decodeFile(filePathForLocalPlace.get(0));
            holder.cityImage.setImageBitmap(bitmap);
            holder.cityImage.setImageBitmap(bitmap);

        }*/
        /*else {*/
            GridViewModel gridView_model = alGridview.get(position);
            Bitmap bitmap = BitmapFactory.decodeFile(filePath.get(position));
            holder.cityImage.setImageBitmap(bitmap);
            holder.cityName.setText(gridView_model.getCityName());

       /* }*/


        return convertView;


    }


    class ViewHolder {

        ImageView cityImage;
        TextView cityName;

        void bind(View view) {

            cityImage = (ImageView) view.findViewById(R.id.iv_City);
            cityName = (TextView) view.findViewById(R.id.tv_CityName);
        }
    }




}


