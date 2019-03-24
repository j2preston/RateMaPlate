package com.example.ratemaplateswipeplatepage.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.ratemaplateswipeplatepage.Model.ImageF;
import com.example.ratemaplateswipeplatepage.R;
import com.example.ratemaplateswipeplatepage.adapters.RecyclerViewAdapter;

import java.util.ArrayList;

import static com.example.ratemaplateswipeplatepage.Controller.MainActivity.user1;

public class matches_activity extends MenuActivity {

    // for debugging
    private static final String TAG = "matches_Activity";

    private RecyclerViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.matches_activity, contentFrameLayout);


        // debugging
        Log.d(TAG, "onCreate: started");


        initRecyclerView();


    }


    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init RecyclerView");
        adapter = new RecyclerViewAdapter(user1.getLikedImages(), this);
        final RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final SwipeController swipeController = new SwipeController(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                final int position = viewHolder.getAdapterPosition();
                ImageF faveItem = adapter.mFoodItems.get(position);
                boolean repeatItem = false;
                for (i=0; i < user1.getFavouriteImages().size(); i++){
                    if (faveItem.getImageNumber() == user1.getFavouriteImages().get(i).getImageNumber()){
                        repeatItem = true;
                    }
                }
                if (repeatItem == false){
                    user1.addToFavourite(faveItem);
                    Toast.makeText(mContext, "Added to Favourites", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(mContext, "Plate already in Favourites", Toast.LENGTH_SHORT).show();
                }
                adapter.notifyDataSetChanged();
            }
        };

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);
    }



    // search bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_drawer, menu);

        final MenuItem searchItem = menu.findItem(R.id.image_title);
        final SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d(TAG, adapter.getFilter().toString());
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    public void toMatchesClick(View view){
        Intent intent = new Intent(this, matches_activity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }



}