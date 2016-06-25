package com.sugarcoder.cameraapp;

import android.content.Intent;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import java.io.File;


public class MainActivity extends AppCompatActivity {

    Button cam_button;
    ImageView imageView;

    // static final int CAMERA_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cam_button = (Button) findViewById(R.id.cam_button);
        imageView = (ImageView) findViewById(R.id.imageV);

        cam_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(cameraIntent, 1);
            }
        });

    }


    private File getFile() {
        File folder = new File("sdcard/camera_app");
        if(folder.exists())
            folder.mkdir();

        File imageFile = new File("cameraImage.jpg");

        return imageFile;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String path = "sdcard/camera_app/cameraImage.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }


}