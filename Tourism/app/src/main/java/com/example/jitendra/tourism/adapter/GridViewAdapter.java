package com.example.jitendra.tourism.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.model.GridViewModel;
import java.util.ArrayList;


/**
 * Created by jitendra on 19/04/2017.
 */

public class GridViewAdapter extends BaseAdapter {

    private ArrayList<GridViewModel> alGridview =new ArrayList<GridViewModel>();
    private ArrayList<String> filePath =new ArrayList<String>();

    //constructor to initialize GridView ArrayLIst and filepath
    public GridViewAdapter(ArrayList<GridViewModel> alGridview, ArrayList<String> filePath) {
        this.alGridview = alGridview;
        this.filePath = filePath;
    }


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

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listcities, parent, false);

            holder = new ViewHolder();
            holder.bind(convertView);
            convertView.setTag(holder);
        }

        else {


            holder = (ViewHolder) convertView.getTag();
        }


            GridViewModel gridView_model = alGridview.get(position);
            Bitmap bitmap = BitmapFactory.decodeFile(filePath.get(position));
            holder.cityImage.setImageBitmap(bitmap);
            holder.cityName.setText(gridView_model.getCityName());

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


