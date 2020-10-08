package com.codewithharry.awesomewall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
        WallpaperManager wallpaperManager;
        Bitmap bitmap1,bitmap2;
        DisplayMetrics displayMetrics;
        int width,height;
        BitmapDrawable bitmapDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.buttonSet);
        ImageView imageView=findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.img9);

        wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
        bitmapDrawable=(BitmapDrawable)imageView.getDrawable();



        bitmap1=bitmapDrawable.getBitmap();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetScreenWidthHeight();
                SetBitmapSize();

                wallpaperManager=WallpaperManager.getInstance(MainActivity.this);

                try {
                    wallpaperManager.setBitmap(bitmap2);
                    wallpaperManager.suggestDesiredDimensions(width,height);
                    Toast.makeText(MainActivity.this, "SuccessFull!!!  load IMG ", Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }

    private void SetBitmapSize() {
        bitmap2=Bitmap.createScaledBitmap(bitmap1,width,height,false);
    }

    private void GetScreenWidthHeight() {
        DisplayMetrics desplaymetrics= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(desplaymetrics);

        width= desplaymetrics.widthPixels;
        height=desplaymetrics.heightPixels;
    }


    public void button(View view) {
        GetScreenWidthHeight();
        SetBitmapSize();

        wallpaperManager=WallpaperManager.getInstance(MainActivity.this);

        try {
            wallpaperManager.setBitmap(bitmap2);
            wallpaperManager.suggestDesiredDimensions(width,height);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
