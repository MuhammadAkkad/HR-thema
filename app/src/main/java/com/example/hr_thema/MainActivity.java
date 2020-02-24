package com.example.hr_thema;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hr_thema.login.LoginActivity;
import com.example.hr_thema.slider.Slider;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {
    SliderView sliderView;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Splash screen demo
        long start = System.currentTimeMillis();
        long end = start + 1*1000; // 60 seconds * 1000 ms/sec
        while (System.currentTimeMillis() < end)
        {
            // run
        }
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.btn_login_activity_main);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginPage(v);
            }
        });

        MediaPlayer mp = MediaPlayer.create(this, R.raw.allah);
        mp.start();

        sliderView = findViewById(R.id.imageSlider);

        final Slider adapter = new Slider(this);
        adapter.setCount(3);

        sliderView.setSliderAdapter(adapter);
        // Indicator
        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE);
        //sliderView.setIndicatorSelectedColor(Color.rgb(40, 190, 228));
        //sliderView.setIndicatorUnselectedColor(Color.rgb(205, 205, 205));

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);

        sliderView.setAutoCycle(false);

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });
    }

    public void LoginPage(View view) {
        Intent loginPage = new Intent(this, LoginActivity.class);
        startActivity(loginPage);
    }

}
