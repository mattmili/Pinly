package com.example.pinly;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;


import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class addOptions extends Activity implements OnClickListener {
	String hot;
	String cold;
	String mild;
	String snow;
	String sun;
	String rain;
	
	String fullQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);
        
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
    }


    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
    	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + "PINLY" + "_"+timeStamp;
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",         /* suffix */
            storageDir      /* directory */
        );

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
		hot = "no";
		cold = "no";
		mild = "no";
		snow = "no";
		sun = "no";
		rain = "no";
		switch(v.getId()){
		
		case R.id.opB1:
			dispatchTakePictureIntent();
		   
			break;
		case R.id.checkBox1:
			hot = "yes";
			break;
		case R.id.checkBox2:
			cold = "yes";
			break;
		case R.id.checkBox3:
			mild = "yes";
			break;
		case R.id.checkBox4:
			snow = "yes";
			break;
		case R.id.checkBox5:
			sun = "yes";
			break;
		case R.id.checkBox6:
			rain = "yes";
			break;
		
		}
		fullQ = hot+","+cold+","+mild+","+snow+","+sun+","+","+rain;
	}
}
