package com.example.jitendra.tourism.adapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitendra.tourism.Activities.Activity5_a_FamousPlaces;
import com.example.jitendra.tourism.model.Places;
import com.example.jitendra.tourism.R;
import com.example.jitendra.tourism.utils.RecyclerViewItemClickListener;

import java.util.ArrayList;

/**
 * Created by jitendra on 08/04/2017.
 */

//adapter class to handle cardview

public class Places_Adapter extends RecyclerView.Adapter<Places_Adapter.Places_ViewHolder>  {


    //creating object of famous places card view class
    Activity5_a_FamousPlaces famousPlaces_cardView =new Activity5_a_FamousPlaces();

   ArrayList<Places> place=new ArrayList<Places>();
    private String CardViewNo_4_Text ="Tap Here";   //String to compare text of no4 image in cardview

    private RecyclerViewItemClickListener onRecycleView_ItemClickListener;

    //setter for setOnClickViewItmListener
    public void setOnRecycleView_ItemClickListener(RecyclerViewItemClickListener onRecycleView_ItemClickListener) {
        this.onRecycleView_ItemClickListener = onRecycleView_ItemClickListener;
    }

    public Places_Adapter(ArrayList<Places> place) {
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
        holder.City_img1.setImageResource(PLA.getImage_id());
        holder.City_name1.setText(PLA.getName());
        holder.City_detail1.setText(PLA.getDetail());

        //checking if image with + sign is holding by card view or not if it is than make it clickable
        if(CardViewNo_4_Text.equals(holder.City_name1.getText().toString())) {

            holder.City_detail1.setVisibility(View.GONE);
            holder.City_name1.setVisibility(View.GONE);
            holder.Add_Name.setVisibility(View.VISIBLE);
            holder.Add_Detail.setVisibility(View.VISIBLE);

            //OnClickListener for image
            holder.City_img1.setOnClickListener(new View.OnClickListener() {
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

            holder.City_detail1.setVisibility(View.VISIBLE);
            holder.City_name1.setVisibility(View.VISIBLE);
            holder.Add_Name.setVisibility(View.GONE);
            holder.Add_Detail.setVisibility(View.GONE);
        }




    }


    @Override
    public int getItemCount() {
        return place.size();
    }


     //View Holder class
    public static class Places_ViewHolder extends RecyclerView.ViewHolder{


        ImageView City_img1;
        TextView City_name1,City_detail1 ;
        EditText Add_Name,Add_Detail;


        public Places_ViewHolder(View view) {
            super(view);
            City_img1=(ImageView) view.findViewById(R.id.iv_places1);
            City_name1=(TextView) view.findViewById(R.id.tv_Places1Text1);
            City_detail1=(TextView) view.findViewById(R.id.tv_Places1Text2);
            Add_Name=(EditText) view.findViewById(R.id.et_name);
            Add_Detail=(EditText) view.findViewById(R.id.et_details);


        }
    }
}
