package com.example.rahul.customadapter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

     String path="/storage/emulated/0/WhatsApp/Media/WhatsApp Images/";
      ListView l;
     MainActivity a;
     File f=new File(path);

     File f1[]=f.listFiles();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=this;
        l=findViewById(R.id.lview);
        int status= ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(status== PackageManager.PERMISSION_GRANTED)
        {
            readFiles();
        }
        else
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},11);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            readFiles();
        }
    }

    public void readFiles()
    {

        File f=new File(path);
        if(!f.exists())
        {
            path="/storage/sdcard0/WhatsApp/Media/WhatsApp Images/";
            f=new File(path);
        }

        l.setAdapter(new MyAdapter(this,f1));



    }
   /* public void refresh()
    {
        l.setAdapter(new MyAdapter(a,f1));

    }*/
}
