package com.example.ratemaplateswipeplatepage.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ratemaplateswipeplatepage.R;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //creates a view for the navigation menu
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //sets burger button on toolbar to open navigation menu
        ImageView clickBurger = (ImageView) findViewById(R.id.burgerButton);
        clickBurger.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }

    //closes the menu if the back button is tapped
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //sets the clickable options for each menu item
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my_uploaded_plates) {
            Toast.makeText(this, "To Alans Prototype", Toast.LENGTH_SHORT).show(); //TODO: Put intents on the buttons
        } else if (id == R.id.nav_upload) {
            Toast.makeText(this, "To Alans Prototype", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_my_matches) {
            Intent intent =  new Intent(this, matches_activity.class);
            startActivity(intent);
        } else if (id == R.id.nav_favourites) {
            Intent intent = new Intent(this, FavouritesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_log_out) {
            Toast.makeText(this, "Under maintenance", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void dashBoardClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
