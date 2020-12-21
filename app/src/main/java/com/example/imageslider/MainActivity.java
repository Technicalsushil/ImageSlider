package com.example.imageslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   ViewPager vpgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpgr=findViewById(R.id.vpgr);
        ImageAdapter adapter=new ImageAdapter(this);
        vpgr.setAdapter(adapter);
    }

    class ImageAdapter extends PagerAdapter{
        private Context context;
        private int[] imgid=new int[]{R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4};

        public ImageAdapter(Context context1) {
            context=context1;
        }

        @Override
        public int getCount() {
            return imgid.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView img=new ImageView(context);
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setImageResource(imgid[position]);
            container.addView(img,0);
            return img;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ImageView)object);
        }
    }
 }