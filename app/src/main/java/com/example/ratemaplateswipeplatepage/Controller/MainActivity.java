package com.example.ratemaplateswipeplatepage.Controller;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ratemaplateswipeplatepage.Model.ImageF;
import com.example.ratemaplateswipeplatepage.Model.User;
import com.example.ratemaplateswipeplatepage.Model.appImageCollection;
import com.example.ratemaplateswipeplatepage.R;

public class MainActivity extends MenuActivity {

    static int counter = 0;

    //create toast for error message
    Toast imagesFinished;

    //create a dummy user
    static User user1 = new User("Smith");

    //Create the apps image collection
    static appImageCollection imageLibrary = new appImageCollection();

    //create the images that will be added to the apps library
    ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
    ImageF image2 = new ImageF(R.drawable.dish2, "Chicken Wraps", "Underseasoned chicken with no sauce");
    ImageF image3 = new ImageF(R.drawable.dish3, "Pizza", "Pizza with veggies");
    ImageF image4 = new ImageF(R.drawable.colincatepillar, "Camilla The Caterpillar", "Choco goodness");
    ImageF image5 = new ImageF(R.drawable.nuggetsbenedict,"Nuggets Benedict", "Nuggets Benedict with a garnish of BBQ sauce");
    ImageF image6 = new ImageF(R.drawable.racingcheeseontoast, "Cheesy Chess Board", "Chess board consisting of Rubber cheese and bread");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);


        imageLibrary.addImage(image1);
        imageLibrary.addImage(image2);
        imageLibrary.addImage(image3);
        imageLibrary.addImage(image4);
        imageLibrary.addImage(image5);
        imageLibrary.addImage(image6);

        //set the initial values of all the fields
        ImageView image = findViewById(R.id.uploadedImage);
        image.setImageResource(imageLibrary.getAppCollection().get(counter).getImageNumber());
        TextView dishTitle = findViewById(R.id.dishTitle);
        dishTitle.setText(imageLibrary.getAppCollection().get(counter).getTitle());
        TextView dishSummary = findViewById(R.id.dishSummary);
        dishSummary.setText(imageLibrary.getAppCollection().get(counter).getDescription());


    }

    public void animateRight(){
        ImageView image = findViewById(R.id.uploadedImage);
        ObjectAnimator animationToRight = ObjectAnimator.ofFloat(image, "translationX", 1000f);
        animationToRight.setDuration(200);
        animationToRight.start();
    }



    public void setImage(){
        ImageView image = findViewById(R.id.uploadedImage);
        image.setImageResource(imageLibrary.getAppCollection().get(counter).getImageNumber());
    }

    public void setDescription(){
        TextView dishSummary = findViewById(R.id.dishSummary);
        dishSummary.setText(imageLibrary.getAppCollection().get(counter).getDescription());
    }

    public void setTitle(){
        TextView dishTitle = findViewById(R.id.dishTitle);
        dishTitle.setText(imageLibrary.getAppCollection().get(counter).getTitle());
    }

    /*
     * This method add the image currently displayed in the imageView to the
     * users liked images list and changes the view of the imageView to the next
     * image on the list as well as the Title and descriptions.
     */
    public void likeButtonClick(View view){
        user1.addToLiked(imageLibrary.getAppCollection().get(counter));
        counter++;
        Intent intent = new Intent(this, itsamatchpage.class);
        startActivity(intent);

    }

    public void dislikeButtonClick(View view){
        counter++;
        if (counter == imageLibrary.getAppCollection().size()){
            imagesFinished = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG);
            imagesFinished.show();
            ImageView image = findViewById(R.id.uploadedImage);
            image.setImageResource(R.drawable.noimage);
            TextView message = findViewById(R.id.dishSummary);
            message.setText("You have swiped all current dishes. Please wait for more users to upload more!");
            TextView title = findViewById(R.id.dishTitle);
            title.setText("");
            ImageButton like = findViewById(R.id.likeButton);
            like.setEnabled(false);
            ImageButton disLike = findViewById(R.id.crossButton);
            disLike.setEnabled(false);
        }else {
            setImage();
            setDescription();
            setTitle();
        }
    }

    public void toMatchesClick(View view){
        Intent intent = new Intent(this, matches_activity.class);
        startActivity(intent);
    }
}
