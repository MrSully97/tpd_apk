package com.G3Tech.PileDriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class stop_collection extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_collection);

        Button goBackBut = findViewById(R.id.goBackBut);
        Button viewSurveyBut = findViewById(R.id.viewSurveyBut);
        Button startSurveyBut = findViewById(R.id.startSurveyBut);
        goBackBut.setOnClickListener(this);
        viewSurveyBut.setOnClickListener(this);
        startSurveyBut.setOnClickListener(this);

    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.goBackBut:
                finish();
                break;

            case R.id.viewSurveyBut:
                finish();
                openSurveyReport();
                break;

            case R.id.startSurveyBut:
                finish();
                openCollectSurvey();
                break;
        }
    }

    public void openSurveyReport() {
        Intent intent = new Intent(this, surveyReportArea.class);
        startActivity(intent);
    }

    public void openCollectSurvey() {
        Intent intent = new Intent(this, Collect_SurveryTool.class);
        startActivity(intent);
    }
}