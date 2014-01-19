package com.example.pinly;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.example.pinly.R;


import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class addOptions extends Activity implements OnClickListener, OnItemSelectedListener {
	String hot;
	String cold;
	String mild;
	String snow;
	String sun;
	String rain;
	
	ImagesDB db;
	
	String type;
	String fullQ;
	String imageFileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);
        
        db = new ImagesDB(this);
        
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb1.setOnClickListener(this);
        
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb2.setOnClickListener(this);
        
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb3.setOnClickListener(this);
        
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb4.setOnClickListener(this);
        
        CheckBox cb5 = (CheckBox) findViewById(R.id.checkBox5);
        cb5.setOnClickListener(this);
        
        CheckBox cb6 = (CheckBox) findViewById(R.id.checkBox6);
        cb6.setOnClickListener(this);
        
        Button op = (Button) findViewById(R.id.opB1);
        op.setOnClickListener(this);
        
        Spinner spinner = (Spinner) findViewById(R.id.type_spin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        
        //imageFileName is the name of the file
    }


    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
    	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        imageFileName = "JPEG_" + "PINLY" + "_"+timeStamp;
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",         /* suffix */
            storageDir      /* directory */
        );
        fullQ = fullQ+","+image.toString();
        db.addToDB(fullQ);
        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }
    
    static final int REQUEST_TAKE_PHOTO = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                System.out.println("nooooooooooooooo");
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		hot = "false";
		cold = "false";
		mild = "false";
		snow = "false";
		sun = "false";
		rain = "false";
		switch(v.getId()){
		
		case R.id.opB1:
			dispatchTakePictureIntent();
		   
			break;
		case R.id.checkBox1:
			hot = "true";
			break;
		case R.id.checkBox2:
			cold = "true";
			break;
		case R.id.checkBox3:
			mild = "true";
			break;
		case R.id.checkBox4:
			snow = "true";
			break;
		case R.id.checkBox5:
			sun = "true";
			break;
		case R.id.checkBox6:
			rain = "true";
			break;
		
		}
		fullQ = hot+","+cold+","+mild+","+snow+","+sun+","+","+rain;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long id) {
		switch((int)id){

		case 0:
			type = "top";

			break;
		case 1:
			type = "bottom";
			break;
		case 2:
			type = "shoes";
			

			break;

		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}
