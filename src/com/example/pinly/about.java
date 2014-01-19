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
        
        about_us.setText("\t\t FOR NEXT TIME");
        faq.setText("IT'S AN APP");
    }



    
}
