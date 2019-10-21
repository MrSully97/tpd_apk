package com.G3Tech.PileDriver;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Collect_SurveryTool extends AppCompatActivity implements OnClickListener {

    EditText nameField;
    ProgressBar spinner;
    String url;
    String result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect__survery_tool);

        Button goBackBut = findViewById(R.id.goBackBut);
        Button submitBut = findViewById(R.id.submitBut);
        Button gpsBut = findViewById(R.id.gpsBut);
        spinner = findViewById(R.id.progressBar2);
        goBackBut.setOnClickListener(this);
        submitBut.setOnClickListener(this);
        gpsBut.setOnClickListener(this);

        nameField = (EditText) findViewById(R.id.fileField);
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.goBackBut:
                finish();
                break;

            case R.id.submitBut:
                String name = nameField.getText().toString();
                url = "http://10.211.170.1:5000/collect";

                getWebsite(name, url);
                openCollectionActivity(name);
                finish();
                break;

            case R.id.gpsBut:
                url = "http://10.211.170.1:5000/gps";
                getGps gps = new getGps();
                gps.execute();
                break;
        }
    }

    public void openCollectionActivity(String name) {
        Intent intent = new Intent(this, CollectionArea.class);
        intent.putExtra("theName", name);
        startActivity(intent);
    }

    private void getWebsite(String name, String _url) {

        OkHttpClient client = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
                .add("text", name)
                .build();

        Request request = new Request.Builder()
                .url(_url)
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Accept", "application/x-www-form-urlencoded; charset=UTF-8")
                .post(body)
                .build();

       client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Collect_SurveryTool.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String myResponse = response.body().string();
                Collect_SurveryTool.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), myResponse, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

   private class getGps extends AsyncTask<Void, Void, Void> {
       ProgressBar loadingBar = findViewById(R.id.progressBar2);
       @Override
       protected void onPreExecute() {
           super.onPreExecute();
       }

       @Override
       protected void onPostExecute(Void aVoid) {
           super.onPostExecute(aVoid);
           Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
       }

       @Override
       protected Void doInBackground(Void... voids) {
           //spinner.setVisibility(View.VISIBLE);
           try {
               Document doc = Jsoup.connect("http://10.211.170.1:5000/gps").get();
               Elements test = doc.select("p");
               result = test.text();
           } catch (IOException e) {
               e.printStackTrace();
           }
           return null;
       }

   }
}
