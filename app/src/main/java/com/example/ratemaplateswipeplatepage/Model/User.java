package com.example.ratemaplateswipeplatepage.Model;

import java.util.ArrayList;

public class User {

    private String username;
    private ArrayList<ImageF> likedImages;
    private ArrayList<ImageF> favouriteImages;


    //constructor for the user class, creates 2 lists and takes in a username String as a parameter
    public User(String username){
        this.username = username;
        likedImages = new ArrayList<ImageF>();
        favouriteImages = new ArrayList<ImageF>();
    }

    //method to return the favourites arraylist of the user
    public ArrayList<ImageF> getFavouriteImages() {
        return favouriteImages;
    }

    //method to return the liked images arraylist of the user
    public ArrayList<ImageF> getLikedImages() {
        return likedImages;
    }


    //method to returnt the username of the user
    public String getUsername() {
        return username;
    }

    //method to set the value of the username of the user - would be useful for a edit profile page
    public void setUsername(String username) {
        this.username = username;
    }

    //method to add an image to the liked list of the user
    public void addToLiked(ImageF image){
        likedImages.add(image);
    }

    //method to add an image to the favourite list of the user
    public void addToFavourite(ImageF image){
        favouriteImages.add(image);
    }


}
