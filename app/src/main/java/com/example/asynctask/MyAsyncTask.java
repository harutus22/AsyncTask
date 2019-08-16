package com.example.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;

public class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {
    private final String TAG = "Async";
    private WeakReference<MainActivity> activity;

    public MyAsyncTask(MainActivity activity){
        this.activity = new WeakReference<>(activity);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        MainActivity mainActivity = activity.get();
        mainActivity.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap = null;
        try {
            InputStream inputStream = new URL(strings[0]).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {
            Log.d(TAG, "Something went wrong!");
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        MainActivity mainActivity = activity.get();
        mainActivity.progressBar.setVisibility(View.INVISIBLE);
        mainActivity.imageView.setImageBitmap(bitmap);
    }

}
