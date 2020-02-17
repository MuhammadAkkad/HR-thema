package com.example.hr_thema.login;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.TextView;

import com.example.hr_thema.R;

public class LoggedInActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);


        textView = findViewById(R.id.textView13);

        TextPaint paint = textView.getPaint();
        float width = paint.measureText("Bu kullanıcı, sen misin ?");

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#CF8FDC"),
                        Color.parseColor("#D691C1"),
                        Color.parseColor("#E1939E"),
                        Color.parseColor("#ED9576"),
                        Color.parseColor("#F39663"),
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
    }
}
