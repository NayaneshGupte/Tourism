
//class to display data in recyclerview

package com.example.jitendra.tourism.model;


public class Places {

    private String name;
    private String detail;

    public Places(String name, String detail) {
        this.name = name;
        this.detail = detail;
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
