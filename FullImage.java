package com.example.rahul.customadapter;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class FullImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        ImageView i = findViewById(R.id.iview);
        String img = getIntent().getStringExtra("name");
        File f2 = new File(img);
        if (!f2.exists()) {
            Toast.makeText(this, "Invalid Path ", Toast.LENGTH_LONG).show();
        } else {
            try {
                i.setImageURI(Uri.fromFile(f2));
            } catch (NullPointerException e) {
                Toast.makeText(this, img, Toast.LENGTH_LONG).show();

            }


        }
    }
}
