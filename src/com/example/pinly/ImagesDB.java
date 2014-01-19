package com.example.pinly;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
	public static final String RAIN = "Rain";
	public static final String TYPE = "Type";
	private static final String DATABASE_NAME="images.db";
	private static final int DATABASE_VERSION = 2;
	
	
	
	public ImagesDB (Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database){
		String DATABASE_CREATE = "CREATE TABLE if not exists "+ TABLE_IMAGES + "(" + FILE_NAME+ " TEXT, " +HOT + " TEXT, " + COLD+ " TEXT, " + MILD + " TEXT, "+ SNOW + " TEXT, "+ SUN + " TEXT, " + RAIN + " TEXT, "+ TYPE + " TEXT);";
		database.execSQL(DATABASE_CREATE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGES);
	    onCreate(db);
	}
	
	public void addToDB (String inputStream){
		SQLiteDatabase db = this.getWritableDatabase();
		
		String[] parse = inputStream.split(",");
		
		ContentValues values = new ContentValues();
		values.put(FILE_NAME, parse[6]);
		values.put(HOT, parse[0]);
		values.put(COLD, parse[1]);
		values.put(MILD, parse[2]);
		values.put(SNOW, parse[3]);
		values.put(SUN, parse[4]);
		values.put(RAIN, parse[5]);
		values.put(TYPE, parse[7]);
		db.insert(TABLE_IMAGES, null, values);
		
		db.close();	
	}
	public Cursor queryDB (String inputStream){
		SQLiteDatabase db = this.getReadableDatabase();
		String[] columnNames = {"Hot", "Cold", "Mild","Snow","Sun","Rain","Type"};
		String[] parse = inputStream.split(",");
		Cursor cursor = db.query(
			TABLE_IMAGES, columnNames,
			"Hot=? AND Cold=? AND Mild=? AND Snow=? AND Sun=? AND Rain=? AND Type=?",
			parse,null,null,null);
		return cursor;
	}
}
 