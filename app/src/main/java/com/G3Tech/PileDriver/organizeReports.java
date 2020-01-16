package com.G3Tech.PileDriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class organizeReports extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organize_reports);

        Button goBackBut = findViewById(R.id.goBackBut);
        Button survBut = findViewById(R.id.survBut);
        Button corrBut = findViewById(R.id.corrBut);

        goBackBut.setOnClickListener(this);
        survBut.setOnClickListener(this);
        corrBut.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.goBackBut:
                finish();
                break;

            case R.id.corrBut:
                openManageCorrActivity();
                break;

            case R.id.survBut:
                openManageSurvActivity();
                break;
        }
    }

    public void openManageCorrActivity() {
        Intent intent = new Intent(this, manageCorrReports.class);
        startActivity(intent);
    }

    public void openManageSurvActivity() {
        Intent intent = new Intent(this, manageSurvReports.class);
        startActivity(intent);
    }


}