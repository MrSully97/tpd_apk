package com.G3Tech.PileDriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button but1 = findViewById(R.id.but1);    //initalizes Button1
        final Button gpsBut = findViewById(R.id.gpsBut);    //initalizes GpsButton
        final Button HS2_0But = findViewById(R.id.HS2_0But);
        final Button but4 = findViewById(R.id.surveillanceBut);
        final Button but5 = findViewById(R.id.but5);
        final Button but6 = findViewById(R.id.but6);
        final Button but7 = findViewById(R.id.but7);
        final Button but8 = findViewById(R.id.but8);
        final Button but9 = findViewById(R.id.but9);
        final Button but10 = findViewById(R.id.but10);
        final Button but11 = findViewById(R.id.but11);
        final Button but12 = findViewById(R.id.but12);
        final Button but13 = findViewById(R.id.but13);
        final Button but14 = findViewById(R.id.but14);
        but1.setOnClickListener(this);
        gpsBut.setOnClickListener(this);
        HS2_0But.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);
        but9.setOnClickListener(this);
        but10.setOnClickListener(this);
        but11.setOnClickListener(this);
        but12.setOnClickListener(this);
        but13.setOnClickListener(this);
        but14.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.but1:
                //openbrowserActivity("http://10.211.170.1:5000/fn-choice_survey");
                openToolActivity();
                break;

            case R.id.gpsBut:
                //openbrowserActivity("http://10.211.170.1:5000/fn-choice");
                openCorrelationActivity();
                break;

            case R.id.HS2_0But:
                //openbrowserActivity("http://10.211.170.1:5000/hs2");
                openHS2_0Activity();
                break;

            case R.id.surveillanceBut:
                //openbrowserActivity("http://10.211.170.1:5000/sdet");
                openSurveillanceActivity();
                break;
        }
    }


    public void openbrowserActivity(String uuu) {
        Intent intent = new Intent(this, browserActivity.class);
        intent.putExtra("Url", uuu );
        startActivity(intent);
    }

    public void openToolActivity() {
        Intent intent = new Intent(this, Collect_SurveryTool.class);
        startActivity(intent);
    }

    public void openCorrelationActivity() {
        Intent intent = new Intent(this, Correlation_AreaTool.class);
        startActivity(intent);
    }

    public void openHS2_0Activity() {
        Intent intent = new Intent(this, HS2_0Mode.class);
        startActivity(intent);
    }

    public void openSurveillanceActivity() {
        Intent intent = new Intent(this, SurvDetection.class);
        startActivity(intent);
    }
}
