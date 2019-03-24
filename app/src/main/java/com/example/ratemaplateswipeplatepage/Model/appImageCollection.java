package com.example.ratemaplateswipeplatepage.Model;

import java.util.ArrayList;

public class appImageCollection {

    private ArrayList<ImageF> appCollection;

    //constructor for the apps image collection
    public appImageCollection(){
        appCollection = new ArrayList<ImageF>();
    }

    //method to return the arraylist of the apps image collection
    public ArrayList<ImageF> getAppCollection() {
        return appCollection;
    }

    //method to add an image to the apps image collection - simulating an upload
    public void addImage(ImageF image){
        appCollection.add(image);
    }
}
