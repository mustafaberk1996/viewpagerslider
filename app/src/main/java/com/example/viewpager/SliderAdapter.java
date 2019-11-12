package com.example.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private Context context;
    private int _position = 0;

    public SliderAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int[] slide_images = {
            R.mipmap.card4,
            R.mipmap.card5,
            R.mipmap.card6,
    };
    public String[] slide_headers = {
            "HEADER 1 ",
            "HEADER 2 ",
            "HEADER 3 ",
    };

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ///infinite scroll
        if (_position >= slide_headers.length - 1) {
            _position = 0;
        } else {
            ++_position;
        }

        View view = layoutInflater.inflate(R.layout.rl_page_view_item, container, false);


        ImageView img = view.findViewById(R.id.img);
        TextView tvHeader = view.findViewById(R.id.tvHeader);

        img.setImageResource(slide_images[_position]);
        tvHeader.setText(slide_headers[_position]);


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}























