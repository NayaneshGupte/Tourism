
//class to display data in recyclerview

package com.example.jitendra.tourism.model;
import java.util.ArrayList;


public class Places {

    private int Image_id;
    private String name;
    private String detail;

    public Places(int image_id, String name, String detail) {
        Image_id = image_id;
        this.name = name;
        this.detail = detail;
    }

    public int getImage_id() {
        return Image_id;
    }

    public void setImage_id(int image_id) {
        Image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
