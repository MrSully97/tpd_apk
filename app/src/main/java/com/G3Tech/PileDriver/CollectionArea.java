package com.G3Tech.PileDriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CollectionArea extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_area);

        Button goBackBut = findViewById(R.id.goBackBut);
        Button stopBut = findViewById(R.id.stopBut);
        TextView fileName = findViewById(R.id.textView3);
        goBackBut.setOnClickListener(this);
        stopBut.setOnClickListener(this);

        String thefileName = getIntent().getStringExtra("theName");
        fileName.append(thefileName);

    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.goBackBut:
                finish();
                break;

            case R.id.stopBut:
                getWebsite();
                openStopCollect();
                finish();
                break;
        }
    }

    public void openStopCollect() {
        Intent intent = new Intent(this, stop_collection.class);
        startActivity(intent);
    }

    private void getWebsite() {

        String _url = "http://10.211.170.1:5000/stop_collection";

        OkHttpClient client = new OkHttpClient();
        //Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();

       /* RequestBody body = new FormBody.Builder()
                .add("text", name)
                .build();*/

        Request request = new Request.Builder()
                .url(_url)
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Accept", "application/x-www-form-urlencoded; charset=UTF-8")
                //.post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                CollectionArea.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String myResponse = response.body().string();
                CollectionArea.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), myResponse, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

}
