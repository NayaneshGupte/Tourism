
//class to display data in recyclerview

package com.example.jitendra.tourism.model;


public class Places {

    private int imageId;
    private String name;
    private String detail;

    public Places(int imageId, String name, String detail) {
        this.imageId = imageId;
        this.name = name;
        this.detail = detail;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
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
