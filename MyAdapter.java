package com.example.rahul.customadapter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Rahul on 1/3/2018.
 */

public class MyAdapter extends BaseAdapter {
    String path="/storage/emulated/0/WhatsApp/Media/WhatsApp Images/";
    MainActivity m;
    File[] f;
    MyAdapter(MainActivity m,File[] f)
    {
        this.m=m;
        this.f=f;
    }
    @Override
    public int getCount() {

        return f.length;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final int i2=i;
        LayoutInflater inflater=LayoutInflater.from(m);
        View v=inflater.inflate(R.layout.myadapter,null);
        ImageView img=v.findViewById(R.id.img);
        TextView tv=v.findViewById(R.id.fname);
        TextView tv1=v.findViewById(R.id.fsize);
        Button del=v.findViewById(R.id.del);
       final String path1=path+f[i];
        final File new_path=new File(path1);
        Bitmap bitmap=BitmapFactory.decodeFile(f[i].getPath());
        Bitmap bmp= ThumbnailUtils.extractThumbnail(bitmap,80,80);
        img.setImageBitmap(bmp);
        tv.setText(f[i].getName());
        long size=f[i].length()/1024;

        tv1.setText(size+" KB");
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(m,FullImage.class);
                i1.putExtra("name",f[i2].getPath());
                m.startActivity(i1);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new_path.delete();
                File f2=new File(path);
                if(!f2.exists())
                {
                    path="/storage/sdcard0/WhatsApp/Media/WhatsApp Images/";
                    f2=new File(path);
                }
                f=f2.listFiles();
                notifyDataSetChanged();
                Toast.makeText(m,"File is Deleted",Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }


    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }
}

