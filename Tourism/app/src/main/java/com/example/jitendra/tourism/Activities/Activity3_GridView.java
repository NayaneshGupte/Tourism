
//GridView Of cities

package com.example.jitendra.tourism.Activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitendra.tourism.R;

import java.util.ArrayList;

public class Activity3_GridView extends AppCompatActivity {

    private GridView Gridview;

    //Array list to store City name and images
    private ArrayList<String> City_List = new ArrayList<>();
    private ArrayList<Drawable> City_ImageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        Gridview = (GridView) findViewById(R.id.gv_GrinView1);

        //adding city names to arraylist
        City_List.add("Delhi");
        City_List.add("Mumbai");
        City_List.add("Chennai");
        City_List.add("Kolkata");
        City_List.add("Lucknow");
        City_List.add("Hyderabad");
        City_List.add("Ahemedabad");
        City_List.add("Bangluru");
        City_List.add("Add local Place");

        //adding city images to arraylist
        City_ImageList.add(getDrawable(R.drawable.delhi));
        City_ImageList.add(getDrawable(R.drawable.mumbai));
        City_ImageList.add(getDrawable(R.drawable.chennai));
        City_ImageList.add(getDrawable(R.drawable.kolkatta));
        City_ImageList.add(getDrawable(R.drawable.lucknow));
        City_ImageList.add(getDrawable(R.drawable.hyderabad));
        City_ImageList.add(getDrawable(R.drawable.ahmdbd));
        City_ImageList.add(getDrawable(R.drawable.bang));
        City_ImageList.add(getDrawable(R.drawable.add));

        //calling adapter class on gridview
        Gridview.setAdapter(new Adapter());

        Gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                if(position==8){
                                                    Intent intent = new Intent(Activity3_GridView.this, Activity3_GridView.class);
                                                    startActivity(intent);

                                                }
                                                else {

                                                    Intent intent = new Intent(Activity3_GridView.this, Activity4_CityDiscription.class);
                                                    intent.putExtra("CityNumber", position);
                                                    startActivity(intent);
                                                }
                                            }
                                        }
        );
    }

    //Adapter class defination
    class Adapter extends BaseAdapter {


        @Override
        public int getCount() {
            return City_ImageList.size();
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

                convertView = getLayoutInflater().inflate(R.layout.list_cities, parent, false);

                holder = new ViewHolder();
                holder.bind(convertView);
                convertView.setTag(holder);
            } else {


                holder = (ViewHolder) convertView.getTag();
            }

            holder.CityName.setText(City_List.get(position));
            holder.City.setImageDrawable(City_ImageList.get(position));


            return convertView;
        }
    }

    class ViewHolder {

        ImageView City;
        TextView CityName;

        void bind(View view) {

            City = (ImageView) view.findViewById(R.id.iv_City);
            CityName = (TextView) view.findViewById(R.id.tv_CityName);
        }
    }
}
