package com.G3Tech.PileDriver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Correlation_AreaTool extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correlation__area_tool);


        Button goBackBut = (Button) findViewById(R.id.goBackBut);
        goBackBut.setOnClickListener(this);

    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.goBackBut:
                finish();
                break;
        }
    }

}
