package com.example.jitendra.tourism.model;

/**
 * Created by jitendra on 20/04/2017.
 */

public class GridViewModel {

    private String City_Name;

    public GridViewModel(String city_Name ) {
        City_Name = city_Name;
    }

    public String getCity_Name() {
        return City_Name;
    }

    public void setCity_Name(String city_Name) {
        City_Name = city_Name;
    }

}
