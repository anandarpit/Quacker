package com.example.quaker.onBoardScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.quaker.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }
    public int images[] = {
            R.drawable.onboard1,R.drawable.onboard2, R.drawable.onboard3
    };
    public String heading[] = {
            "Welcome On-board!", "Get data that matters!", "Stay Updated"
    };
    public String description[] = {
            "Find data of recent events exclusively on Quaker. Stay updated with the outer world with a very handy and modern " +
                    "mobile application",
            "On Quaker you can can get data of various events say earthquake, weather, news and many cool features to be updated soon!!",
            "Welcome on-board this journey! Click on the button to go to the home page"
    };


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout_file, container, false);

        ImageView slideImage = view.findViewById(R.id.onboard_image);
        TextView slideHeading = view.findViewById(R.id.onboard_heading);
        TextView slideDescription = view.findViewById(R.id.onboard_description);

        slideImage.setImageResource(images[position]);
        slideHeading.setText(heading[position]);
        slideDescription.setText(description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
