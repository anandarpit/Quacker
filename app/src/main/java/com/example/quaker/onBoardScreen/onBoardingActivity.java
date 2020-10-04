package com.example.quaker.onBoardScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quaker.HomePage;
import com.example.quaker.R;

public class onBoardingActivity extends AppCompatActivity {

    ViewPager mViewPager;
    LinearLayout mDots;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button btnPrev;
    Button btnNext;
    int mcurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        mViewPager = findViewById(R.id.viewPager);
        mDots = findViewById(R.id.dots);
        btnPrev = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);

        sliderAdapter = new SliderAdapter(this);
        mViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mViewPager.addOnPageChangeListener(onPageChangeListener);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mcurrentPage >=2){
                    btnNext.setVisibility(View.GONE);
                    Intent intent= new Intent(onBoardingActivity.this, HomePage.class);
                    startActivity(intent);
                    finish();
                }
                mViewPager.setCurrentItem(mcurrentPage + 1);
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mcurrentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position) {
         dots = new TextView[3];
         mDots.removeAllViews();
        for(int i=0; i < dots.length; i++){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.transparentWhite));
            mDots.addView(dots[i]);
        }
        if(position >= 0)
        {
            dots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mcurrentPage = position;
            if(position == 0){
                btnPrev.setEnabled(false);
                btnNext.setText("NEXT");
                btnNext.setEnabled(true);
                btnPrev.setVisibility(View.GONE);
                btnNext.setVisibility(View.VISIBLE);
            }
            else if(position == dots.length - 1){
                btnPrev.setEnabled(true);
                btnPrev.setText("BACK");
                btnNext.setText("FINISH");
                btnNext.setEnabled(true);
                btnPrev.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
            }
            else{
                btnPrev.setEnabled(true);
                btnPrev.setText("BACK");
                btnNext.setEnabled(true);
                btnNext.setText("NEXT");
                btnPrev.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
}