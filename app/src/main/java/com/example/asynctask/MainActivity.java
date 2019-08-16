package com.example.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    protected ImageView imageView;
    protected ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.setImage);
        progressBar = findViewById(R.id.progressBar);
    }

    public void downloadImage(View view){
        MyAsyncTask myAsyncTask = new MyAsyncTask(this);
        String string = "https://api.androidhive.info/json/movies/2.jpg";
        myAsyncTask.execute(string);
    }
}
