package com.example.jitendra.tourism.adapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitendra.tourism.Activities.Activity5aFamousPlaces;
import com.example.jitendra.tourism.model.Places;
import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.utils.RecyclerViewItemClickListener;

import java.util.ArrayList;

/**
 * Created by jitendra on 08/04/2017.
 */

//adapter class to handle cardview

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.Places_ViewHolder>  {


    //creating object of famous places card view class
    Activity5aFamousPlaces famousPlaces_cardView =new Activity5aFamousPlaces();

   ArrayList<Places> place=new ArrayList<Places>();
    private String cardViewNo4Text ="Tap Here";   //String to compare text of no4 image in cardview

    private RecyclerViewItemClickListener onRecycleView_ItemClickListener;

    //setter for setOnClickViewItmListener
    public void setOnRecycleView_ItemClickListener(RecyclerViewItemClickListener onRecycleViewItemClickListener) {
        this.onRecycleView_ItemClickListener = onRecycleViewItemClickListener;
    }

    public PlacesAdapter(ArrayList<Places> place) {
        this.place = place;
    }

    @Override
    public Places_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inflatting carview layout
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.places_cardview,parent,false);
        Places_ViewHolder places_ViewHolder=new Places_ViewHolder(view);
        return  places_ViewHolder;
    }

    @Override
    public void onBindViewHolder(Places_ViewHolder holder, final int position) {


        final Places PLA=place.get(position);
        holder.cityImg1.setImageResource(PLA.getImageId());
        holder.cityName1.setText(PLA.getName());
        holder.cityDetail1.setText(PLA.getDetail());

        //checking if image with + sign is holding by card view or not if it is than make it clickable
        if(cardViewNo4Text.equals(holder.cityName1.getText().toString())) {

            holder.cityDetail1.setVisibility(View.GONE);
            holder.cityName1.setVisibility(View.GONE);
            holder.addName.setVisibility(View.VISIBLE);
            holder.addDetail.setVisibility(View.VISIBLE);

            //OnClickListener for image
            holder.cityImg1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (null != onRecycleView_ItemClickListener) {
                       /* Bundle bundle = new Bundle();
                        bundle.putInt("position", position);
                        bundle.putParcelable("parcel", (Parcelable) PLA);*/
                        onRecycleView_ItemClickListener.onItemClick();
                    }
                }
            });
        }

        else{

            holder.cityDetail1.setVisibility(View.VISIBLE);
            holder.cityName1.setVisibility(View.VISIBLE);
            holder.addName.setVisibility(View.GONE);
            holder.addDetail.setVisibility(View.GONE);
        }




    }


    @Override
    public int getItemCount() {
        return place.size();
    }


     //View Holder class
    public static class Places_ViewHolder extends RecyclerView.ViewHolder{


        ImageView cityImg1;
        TextView cityName1, cityDetail1;
        EditText addName, addDetail;


        public Places_ViewHolder(View view) {
            super(view);
            cityImg1 =(ImageView) view.findViewById(R.id.iv_places1);
            cityName1 =(TextView) view.findViewById(R.id.tv_Places1Text1);
            cityDetail1 =(TextView) view.findViewById(R.id.tv_Places1Text2);
            addName =(EditText) view.findViewById(R.id.et_name);
            addDetail =(EditText) view.findViewById(R.id.et_details);


        }
    }
}