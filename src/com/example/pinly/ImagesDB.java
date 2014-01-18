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
	public static final String WARM = "Warm";
	public static final String RAIN = "Waterproof";
	
	private static final String DATABASE_NAME="images.db";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_IMAGES + "(" + LOCAL_NAME
			+ " text not null, " + FILE_NAME
			+ " text not null, " + HOT + " INTEGER, " + COLD
			+ " INTEGER, " + WARM + " INTEGER "
			+ RAIN + " INTEGER)";
	
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
	
	public void addToDB (String inputStream){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(FILE_NAME, inputStream);
		values.put(LOCAL_NAME, inputStream);
		values.put(HOT, inputStream);
		values.put(COLD, inputStream);
		values.put(WARM, inputStream);
		values.put(RAIN, inputStream);
		db.insert(TABLE_IMAGES, null, values);
		
		db.close();	
	}
	
	/*public Cursor queryDB (String inputStream[]){
		Cursor cursor = getReadableDatabase().
				query(DATABASE_NAME,null,
						"where Hot=? Cold=? warm=? Waterproof=?",
						{"true","true","false","true"},null,null,null);
		return cursor;
	}*/
}
