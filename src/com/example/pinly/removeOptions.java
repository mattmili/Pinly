//Follow this code but query images and deletions and whatnot

package com.example.pinly;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class removeOptions extends Activity implements OnClickListener {
	LinearLayout remove;
	ArrayList<ImageButton> imageList;
	ImageButton a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_activity);
        imageList = new ArrayList<ImageButton>();
        remove = (LinearLayout) findViewById(R.id.removeView);
        imageList.add(new ImageButton(this));
        imageList.get(0).setImageResource(R.drawable.test);
        imageList.get(0).setOnClickListener(this);
        imageList.get(0).setId(0);
        remove.addView(imageList.get(0));
        //perform some sort of query that gets all the images
        //add them to the arraylist and layout
        
    }
	@Override
	public void onClick(View v) {
		
		if (v.getId() == 0){
			AlertDialog.Builder dia =  new AlertDialog.Builder(this);
		    dia.setTitle("Delete entry");
		    dia.setMessage("Are you sure you want to delete this entry?");
		    dia.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     });
		    dia.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     });
		     dia.show();
			
		}
		// TODO Auto-generated method stub
	//depending on the button, delete image from database(** onclick opens dialogue "delete, yes? no?")
	}


}
