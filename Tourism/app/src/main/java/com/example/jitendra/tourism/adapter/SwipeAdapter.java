package com.example.jitendra.tourism.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.model.GalleryModel;

import java.util.ArrayList;

public class SwipeAdapter extends PagerAdapter {


    private ImageView imagsForGallery;
    private TextView imageNumber;
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<GalleryModel> galleryModels;

    public SwipeAdapter(Context context, ArrayList<GalleryModel> galleryModels) {

        this.context = context;
        this.galleryModels = galleryModels;
    }

    @Override
    public int getCount() {
        return galleryModels.size();
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

        //creating object of GalleryModel to keep track on position
        GalleryModel model = galleryModels.get(position);

        imagsForGallery.setImageResource(model.getImageId());
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
