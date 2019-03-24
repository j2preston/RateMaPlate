package com.example.ratemaplateswipeplatepage.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.example.ratemaplateswipeplatepage.Model.ImageF;
import com.example.ratemaplateswipeplatepage.R;
import com.example.ratemaplateswipeplatepage.adapters.FavouritesAdapter;

import java.util.ArrayList;

import static com.example.ratemaplateswipeplatepage.Controller.MainActivity.user1;
import static com.example.ratemaplateswipeplatepage.adapters.RecyclerViewAdapter.mFoodItems;

public class FavouritesActivity extends MenuActivity {

    FavouritesAdapter imageAdapter = new FavouritesAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_favourites, contentFrameLayout);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(imageAdapter);

        imageAdapter.clear();
        for (int i=0; i < user1.getFavouriteImages().size(); i++){
            addToFavourites(user1.getFavouriteImages().get(i));
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(getApplicationContext(), PlateActivity.class);
                intent.putExtra("image_Title", user1.getFavouriteImages().get(position).getTitle());
                intent.putExtra("image_Description", user1.getFavouriteImages().get(position).getDescription());
                intent.putExtra("imageNumber", user1.getFavouriteImages().get(position).getImageNumber());
                intent.putExtra("imageComments", user1.getFavouriteImages().get(position).getComments());
                startActivity(intent);
            }
        });
    }

    public void addToFavourites(ImageF image){
        imageAdapter.addToGrid(image);
        imageAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {

    }


}
