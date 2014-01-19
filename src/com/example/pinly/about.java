package com.example.pinly;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class about extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        TextView about_us = (TextView) findViewById(R.id.au);
        TextView faq = (TextView) findViewById(R.id.faq);
        
        about_us.setText("\t\t Pinly was developed by three students (Matthew Weeks, Matthew Militante, and Collin Stubbs) from the University of Ontario Institute of Technology."+
        " It was designed to be part of the MHACKS III competition and incorporates our knowledge of databases and android development.");
        faq.setText("\t\tWelcome to Pinly! With this application your long and frustrating hours of picking out the right outfit for the day will be gone!"+
        " Pinly lets you take pictures of your clothes, store them on your phone, and generate random outfits based on what the weather is like."+
        		" This app requires access to your camera and image files, this is only for storing and generation of the outfits, we do not do anything further with your files."+
        		" If you wish to learn more about the project, or if you are an aspiring mobile developer looking to know how Pinly was built, our github at https://github.com/matthewmilitante/pinly."+
        		"\n\n\n With the use of this app, you are guaranteed to never be a fashion victim or ensembly challenged!");
    }



    
}
