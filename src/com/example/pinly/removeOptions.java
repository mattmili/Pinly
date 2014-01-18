package com.example.pinly;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class removeOptions extends Activity implements OnClickListener {
	LinearLayout remove;
	ArrayList<ImageButton> imageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_activity);
        //remove = (LinearLayout) findViewById(R.id.removeView);
        //perform some sort of query that gets all the images
        //add them to the arraylist and layout
        
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	//depending on the button, delete image from database(** onclick opens dialogue "delete, yes? no?")
	}


}
