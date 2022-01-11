package com.appdevelopers3a.prepareplaced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class onboarding extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotlayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;
    private ViewPager.OnPageChangeListener viewListener;

   // private Button mNextBtn;
    private Button mBackBtn;
    private Button mFinishBtn;

    private  int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);


        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotlayout = (LinearLayout) findViewById(R.id.dotsLayout);

       // mNextBtn = (Button) findViewById(R.id.nextBtn);
        mBackBtn = (Button) findViewById(R.id.prevBtn);
        mFinishBtn = (Button) findViewById(R.id.FinishBtn);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        //OnClickListeners
//
//        mNextBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mSlideViewPager .setCurrentItem(mCurrentPage + 1);
//            }
//        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager .setCurrentItem(mCurrentPage - 1);
            }
        });


        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[4];
        for (int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotlayout.addView(mDots[i]);

        }
        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
        }


        ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                addDotsIndicator(i);

                mCurrentPage = i;

                if(i == 0){
                  //  mNextBtn.setEnabled(true);
                    mBackBtn.setEnabled(false);
                    mBackBtn.setVisibility(View.INVISIBLE);

                   // mNextBtn.setText("Next");
                    mBackBtn.setText("");
                    mFinishBtn.setVisibility(View.VISIBLE);

                } else if (i == mDots.length - 2 ) {
                  //  mNextBtn.setEnabled(true);
                    mBackBtn.setEnabled(true);
                    mBackBtn.setVisibility(View.VISIBLE);

                  //  mNextBtn.setText("Finish");
                    mBackBtn.setText("Back");
                    mFinishBtn.setVisibility(View.VISIBLE);
                } else {
                   // mNextBtn.setEnabled(true);
                    mBackBtn.setEnabled(true);
                    mBackBtn.setVisibility(View.VISIBLE);

                  //  mNextBtn.setText("Next");
                    mBackBtn.setText("Back");
                   // mNextBtn.findViewById(R.id.nextBtn);
                    mFinishBtn.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        };



    }
}