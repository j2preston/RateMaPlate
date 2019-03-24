package com.example.ratemaplateswipeplatepage.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ratemaplateswipeplatepage.R;

import java.util.ArrayList;

public class PlateActivity extends MenuActivity {

    // define a constant for TAGS
    private static final String TAG = "PlateActivity";
    ArrayList<String> comments;
    ListView myListView;
    Toast error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_plate, contentFrameLayout);

        comments = getIntent().getStringArrayListExtra("imageComments");


        //set up and connect listview to comments arraylist
        myListView = findViewById(R.id.commentView);
        final ArrayAdapter myArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, comments);
        myListView.setAdapter(myArrayAdapter);


        int imageUrl = getIntent().getIntExtra("imageNumber", 0);
        String imageName = getIntent().getStringExtra("image_Title");
        String imageDescription = getIntent().getStringExtra("image_Description");
        Log.d("images", imageName + imageUrl);


        TextView name = findViewById(R.id.image_title);
        name.setText(imageName);


        ImageView image = findViewById(R.id.plateView);
        image.setImageResource(imageUrl);


        comments.add("This image isn't disgusting, why is it on this app");
        comments.add("I wish my mum could cook like this");
        comments.add("This is nice!!!");

        myListView.invalidateViews();


    }


    public void addComment(View view){
        EditText comment = findViewById(R.id.commentField);
        String commentText = comment.getText().toString();
        if (commentText.isEmpty()){
            error = Toast.makeText(getApplicationContext(), "Comment invalid. Please enter a valid comment", Toast.LENGTH_LONG);
            error.show();
        }else {
            comments.add(commentText);
            myListView.invalidateViews();
        }
    }


    public void toMatchesClick(View view){
        Intent intent = new Intent(this, matches_activity.class);
        startActivity(intent);
    }






}
