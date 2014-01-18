
package com.example.pinly;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import android.widget.ImageView;


public class outfits extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outfits_activity);

    }
    
    /*
     * These methods find the photo for the frames based on the path
     * */
    public void findTopFrame(String path){
        ImageView image = (ImageView) findViewById(R.id.top);
        FileInputStream in;
        BufferedInputStream buf;
        try {
            in = new FileInputStream(path);
            buf = new BufferedInputStream(in);
            Bitmap bMap = BitmapFactory.decodeStream(buf);
            image.setImageBitmap(bMap);
            if (in != null) {
                in.close();
            }
            if (buf != null) {
                buf.close();
            }
        } catch (Exception e) {
            Log.e("Error reading file", e.toString());
        }
    }

    public void findMiddleFrame(String path){
        ImageView image = (ImageView) findViewById(R.id.middle);
        FileInputStream in;
        BufferedInputStream buf;
        try {
            in = new FileInputStream(path);
            buf = new BufferedInputStream(in);
            Bitmap bMap = BitmapFactory.decodeStream(buf);
            image.setImageBitmap(bMap);
            if (in != null) {
                in.close();
            }
            if (buf != null) {
                buf.close();
            }
        } catch (Exception e) {
            Log.e("Error reading file", e.toString());
        }
    }

    public void findBottomFrame(String path){

        ImageView image = (ImageView) findViewById(R.id.bottom);
        FileInputStream in;
        BufferedInputStream buf;

        try {
            in = new FileInputStream(path);
            buf = new BufferedInputStream(in);
            Bitmap bMap = BitmapFactory.decodeStream(buf);
            image.setImageBitmap(bMap);
            if (in != null) {
                in.close();
            }
            if (buf != null) {
                buf.close();
            }
        } catch (Exception e) {
            Log.e("Error reading file", e.toString());
        }
    }



}
