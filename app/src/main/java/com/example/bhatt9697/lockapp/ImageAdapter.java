package com.example.bhatt9697.lockapp;

/**
 * Created by bhatt9697 on 1/20/2018.
 */



import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{





    private Context mContext;

    GridView androidGridView;

    public Integer[] mThumbIds = {
            R.drawable.pearr, R.drawable.gg, R.drawable.pp,
            R.drawable.aaa, R.drawable.melon, R.drawable.cherries,
            R.drawable.orange, R.drawable.pomo, R.drawable.guava







    };






    public ImageAdapter(Context c){
        mContext = c;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        if (convertView == null) {

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));

        } else {
            imageView= (ImageView) convertView;

        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }




}
