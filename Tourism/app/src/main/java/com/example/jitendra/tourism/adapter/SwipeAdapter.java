package com.example.jitendra.tourism.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jitendra.tourism.R;

import java.util.ArrayList;

public class SwipeAdapter extends PagerAdapter {


    private ImageView imagsForGallery;
    private TextView imageNumber;
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<String> filePathToReceive = new ArrayList<String>();


    public SwipeAdapter(Context context,ArrayList<String> filePathToReceive) {

        this.context = context;
        this.filePathToReceive=filePathToReceive;
    }

    @Override
    public int getCount() {
        return filePathToReceive.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.image_swipable, container, false);

        imagsForGallery = (ImageView) view.findViewById(R.id.iv_ImagesForGallery);
        imageNumber = (TextView) view.findViewById(R.id.tv_ImageNumber);

        Bitmap bitmap = BitmapFactory.decodeFile(filePathToReceive.get(position));
        imagsForGallery.setImageBitmap(bitmap);
        imageNumber.setText("Image No. : " + (position + 1));
        container.addView(view);

        return view;
    }

    //distroy slides when we move from one slide to another
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
        notifyDataSetChanged();

    }

}
