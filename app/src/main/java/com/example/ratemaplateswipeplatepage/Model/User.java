package com.example.ratemaplateswipeplatepage.Model;

import java.util.ArrayList;

public class User {

    private String username;
    private ArrayList<ImageF> likedImages;
    private ArrayList<ImageF> favouriteImages;


    public User(String username){
        this.username = username;
        likedImages = new ArrayList<ImageF>();
        favouriteImages = new ArrayList<ImageF>();
    }


    public ArrayList<ImageF> getFavouriteImages() {
        return favouriteImages;
    }


    public ArrayList<ImageF> getLikedImages() {
        return likedImages;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void addToLiked(ImageF image){
        likedImages.add(image);
    }

    public void addToFavourite(ImageF image){
        favouriteImages.add(image);
    }


}
