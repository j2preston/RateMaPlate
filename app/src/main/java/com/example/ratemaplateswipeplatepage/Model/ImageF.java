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


    public int getImageNumber() {
        return imageNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void addComment(String comment){
        comments.add(comment);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
