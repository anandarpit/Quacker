package com.example.quaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    LinearLayout earthquakeLinearLayout, weatherLinearLayout, newsLinearLayout , mapsLinearLayout;
    ImageSlider imageSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        imageSlider = findViewById(R.id.imageSlider);
        List<SlideModel> list = new ArrayList<>();
        list.add(new SlideModel("https://cdn.dnaindia.com/sites/default/files/styles/full/public/2017/11/04/622378-cat.jpg","Cat", ScaleTypes.FIT));
        list.add(new SlideModel("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=1200:*","" +
                "Dog",ScaleTypes.FIT));
        list.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQFTVx3o8xfUiBum_qvU-oSkRpJ0cSeBeK7AQ&usqp=CAU","Buffalo",ScaleTypes.FIT));
        imageSlider.setImageList(list,ScaleTypes.FIT);
        imageSlider.startSliding(2000);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                imageSlider.stopSliding();
            }
        });
    }
}