package com.G3Tech.PileDriver;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

        class gpsClass extends AsyncTask<String, Void, Void> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }

            @Override
            protected Void doInBackground(String... Url) {
                String url = Url[0];
                try {
                    Document doc = Jsoup.connect(url).get();
                    Elements test = doc.select("p");
                    //result = test.text();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
