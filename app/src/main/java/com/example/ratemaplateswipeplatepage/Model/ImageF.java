package com.example.ratemaplateswipeplatepage.Model;

import java.util.ArrayList;

public class ImageF {

    private int imageNumber;
    private String title;
    private String description;
    static ArrayList<String> comments;

    public ImageF(int imageNumber, String title, String description){
        this.imageNumber = imageNumber;
        this.title = title;
        this.description = description;
        comments = new ArrayList<String>();
    }


    //method to return the image number(ID) of the image
    public int getImageNumber() {
        return imageNumber;
    }

    //method to return the image description of the image
    public String getDescription() {
        return description;
    }

    //method to return the title of the image
    public String getTitle() {
        return title;
    }

    //method to return the comments on the image
    public ArrayList<String> getComments() {
        return comments;
    }

    //method to add a comment to the comment list of the image
    public void addComment(String comment){
        comments.add(comment);
    }

    //method to set the description string of the image
    public void setDescription(String description) {
        this.description = description;
    }

    //method to set the imageNumber of the image
    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    //method to set the title string of the image
    public void setTitle(String title) {
        this.title = title;
    }
}
