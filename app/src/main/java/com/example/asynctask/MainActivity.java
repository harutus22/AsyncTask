package com.example.asynctask;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private MyAsyncTask myAsyncTask;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.setImage);
        progressBar = findViewById(R.id.progressBar);
    }

    public void downloadImage(View view){
        progressBar.setVisibility(View.VISIBLE);
        myAsyncTask = new MyAsyncTask();
        String string = "https://api.androidhive.info/json/movies/2.jpg";
        myAsyncTask.execute(string);

        try {
            Bitmap bitmap = myAsyncTask.get();
            imageView.setImageBitmap(bitmap);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        progressBar.setVisibility(View.INVISIBLE);
    }
}
