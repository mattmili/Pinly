package com.example.pinly;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ImagesDB extends SQLiteOpenHelper{
	public static final String TABLE_IMAGES="images";
	public static final String LOCAL_NAME = "Local_Name";
	public static final String FILE_NAME = "File_Name";

	public static final String HOT = "Hot";
	public static final String COLD = "Cold";
	public static final String MILD = "Mild";
	public static final String SNOW = "Snow";
	public static final String SUN = "Sun";
	public static final String RAIN = "Waterproof";
	
	private static final String DATABASE_NAME="images.db";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_IMAGES + "(" + LOCAL_NAME
			+ " text not null, " + FILE_NAME
			+ " text not null, " + HOT + " text, " + COLD
			+ " text, " + MILD + " text "
			+ SNOW + " snow " + RAIN + " text)";
	
	public ImagesDB (Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database){
		database.execSQL(DATABASE_CREATE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		Log.w(ImagesDB.class.getName(),
			"Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGES);
	    onCreate(db);
	}
}
