package com.example.jitendra.tourism.model;

/**
 * Created by jitendra on 20/04/2017.
 */

public class GridViewModel {

    private String cityName;

    public GridViewModel(String city_Name ) {
        cityName = city_Name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
