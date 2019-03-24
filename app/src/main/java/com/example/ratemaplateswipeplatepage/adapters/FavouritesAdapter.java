package com.example.ratemaplateswipeplatepage.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.ratemaplateswipeplatepage.Model.ImageF;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class FavouritesAdapter extends BaseAdapter {
    private Context mContext;

    static private int size = 1;
    static private Integer[] mThumbIds = new Integer[size];

    // Constructor
    public FavouritesAdapter(Context c) {
        mContext = c;
    }

    public void addToGrid(ImageF image){
        if (mThumbIds[0] == null){
            mThumbIds[(size-1)] = image.getImageNumber();
        }
        else {
            size = size + 1;
            mThumbIds = Arrays.copyOf(mThumbIds, size);
            mThumbIds[(size - 1)] = image.getImageNumber();
        }
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public Integer[] getMThumbsId(){
        return mThumbIds;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CircleImageView imageView = new CircleImageView(mContext);
        if (mThumbIds[0] != null) {
            imageView.setImageResource(mThumbIds[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new GridView.LayoutParams(350, 350));
            return imageView;
        }
        else{
            return imageView;
        }
    }

    public void clear(){
        for (int i=0; i < mThumbIds.length; i++){
            mThumbIds[i] = null;
        }
        size = 1;
    }

}