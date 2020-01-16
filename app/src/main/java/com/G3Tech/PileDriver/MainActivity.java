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

        final Button collectSurvBut = findViewById(R.id.collectSurvBut);        //initalizes collectSurveyButton
        final Button correlationBut = findViewById(R.id.correlationBut);        //initalizes CorrelationButton
        final Button HS2_0But = findViewById(R.id.HS2_0But);                    //initalizes HS2_0Button
        final Button surveillanceBut = findViewById(R.id.surveillanceBut);      //initalizes surveillanceButton
        final Button gpsBut = findViewById(R.id.gpsBut);                        //initalizes GpsButton
        final Button blueForceBut = findViewById(R.id.blueForceBut);            //initalizes BlueForceButton
        final Button downReportsBut = findViewById(R.id.downReportsBut);
        final Button but8 = findViewById(R.id.but8);
        final Button organizeRepBut = findViewById(R.id.organizeRepBut);
        final Button but10 = findViewById(R.id.but10);
        final Button but11 = findViewById(R.id.but11);
        final Button but12 = findViewById(R.id.but12);
        final Button but13 = findViewById(R.id.but13);
        final Button orgFilesBut = findViewById(R.id.orgFilesBut);
        collectSurvBut.setOnClickListener(this);
        correlationBut.setOnClickListener(this);
        HS2_0But.setOnClickListener(this);
        surveillanceBut.setOnClickListener(this);
        gpsBut.setOnClickListener(this);
        blueForceBut.setOnClickListener(this);
        downReportsBut.setOnClickListener(this);
        but8.setOnClickListener(this);
        organizeRepBut.setOnClickListener(this);
        but10.setOnClickListener(this);
        but11.setOnClickListener(this);
        but12.setOnClickListener(this);
        but13.setOnClickListener(this);
        orgFilesBut.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.collectSurvBut:
                //openbrowserActivity("http://10.211.170.1:5000/fn-choice_survey");
                openToolActivity();
                break;

            case R.id.correlationBut:
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

            case R.id.blueForceBut:
                openBlueForceActivity();
                break;

            case R.id.downReportsBut:
                openDownloadReportsActivity();
                break;

            case R.id.orgFilesBut:
                openOrgFilesActivity();
                break;

            case R.id.organizeRepBut:
                openOrganizeReportsActivity();
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

    public void openBlueForceActivity() {
        Intent intent = new Intent(this, BlueForceArea.class);
        startActivity(intent);
    }

    public void openDownloadReportsActivity() {
        Intent intent = new Intent(this, downloadReports.class);
        startActivity(intent);
    }

    public void openOrgFilesActivity() {
        Intent intent = new Intent(this, organizeFiles.class);
        startActivity(intent);
    }

    public void openOrganizeReportsActivity() {
        Intent intent = new Intent(this, organizeReports.class);
        startActivity(intent);
    }

}
