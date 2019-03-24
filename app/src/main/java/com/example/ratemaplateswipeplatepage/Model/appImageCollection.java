package com.example.ratemaplateswipeplatepage.Model;

import java.util.ArrayList;

public class appImageCollection {

    private ArrayList<ImageF> appCollection;

    public appImageCollection(){
        appCollection = new ArrayList<ImageF>();
    }


    public ArrayList<ImageF> getAppCollection() {
        return appCollection;
    }


    public void addImage(ImageF image){
        appCollection.add(image);
    }
}
