package com.example.ratemaplateswipeplatepage.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ratemaplateswipeplatepage.Controller.PlateActivity;
import com.example.ratemaplateswipeplatepage.Model.ImageF;
import com.example.ratemaplateswipeplatepage.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {

    private static final String TAG = "RecyclerViewAdapter";

    // delcaration
    public static ArrayList<ImageF> mFoodItems;
    private ArrayList<ImageF> mFoodItemsFull;
    private Context mContext;


    // constructor
    public RecyclerViewAdapter(ArrayList<ImageF> mImages, Context mContextl) {
        mFoodItems = new ArrayList<>();
        for (int i = 0; i < mImages.size(); i++) {
            mFoodItems.add(new ImageF(mImages.get(i).getImageNumber(), mImages.get(i).getTitle(), mImages.get(i).getDescription()));
        }

        mFoodItemsFull = new ArrayList<>(mFoodItems);

        this.mContext = mContextl;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // log for debugging
        Log.d(TAG,"onBindViewHolder: called.");


        holder.imageName.setText(mFoodItems.get(position).getTitle());
        holder.image.setImageResource(mFoodItems.get(position).getImageNumber());
        holder.imageDescription.setText(mFoodItems.get(position).getDescription());

        // user clicks on list in the list
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG, "onClick: clicked on:" + mFoodItems.get(position).getTitle());

                //Toast.makeText(mContext, mFoodItems.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                //takes user to the item in the list they clicked on

                Intent intent = new Intent(mContext, PlateActivity.class);

                intent.putExtra("imageComments", mFoodItems.get(position).getComments());
                intent.putExtra("imageNumber", mFoodItems.get(position).getImageNumber());
                intent.putExtra("image_Description", mFoodItems.get(position).getDescription());
                intent.putExtra("image_Title", mFoodItems.get(position).getTitle());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // return the list, without this, blank screen
        return mFoodItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView imageName;
        TextView imageDescription;
        RelativeLayout parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            imageDescription = itemView.findViewById(R.id.image_description);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }



    // search bar filter
    @Override
    public Filter getFilter() {
        return filter;
    }

    public Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<ImageF> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mFoodItemsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ImageF foodItem : mFoodItemsFull) {
                    if (foodItem.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(foodItem);
                    }

                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mFoodItems.clear();
            mFoodItems.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
