package com.example.ratemaplateswipeplatepage.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ratemaplateswipeplatepage.R;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.ratemaplateswipeplatepage.Controller.MainActivity.counter;

public class itsamatchpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itsamatchpage);

        CircleImageView image = findViewById(R.id.itsamatchImage);

        image.setImageResource(MainActivity.imageLibrary.getAppCollection().get(counter-1).getImageNumber());
    }


    public void backToDashboard(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void toMatchesPage(View view) {
        Intent intent = new Intent(this, matches_activity.class);
        startActivity(intent);
    }



    @Override
    public void onBackPressed() {

    }

}


