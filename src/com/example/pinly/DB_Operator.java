package com.example.pinly;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DB_Operator {
	private static SQLiteDatabase db;
	private static ImagesDB dbHelper;
	
	public DB_Operator(Context context){
		dbHelper = new ImagesDB(context);
	}
	
	
	public static void addToDB (String inputStream){
		db = dbHelper.getWritableDatabase();
		
		String[] parse = inputStream.split(",");
		
		ContentValues values = new ContentValues();
		values.put(ImagesDB.FILE_NAME, parse[6]);
		values.put(ImagesDB.HOT, parse[0]);
		values.put(ImagesDB.COLD, parse[1]);
		values.put(ImagesDB.MILD, parse[2]);
		values.put(ImagesDB.SNOW, parse[3]);
		values.put(ImagesDB.SUN, parse[4]);
		values.put(ImagesDB.RAIN, parse[5]);
		db.insert(ImagesDB.TABLE_IMAGES, null, values);
		
		db.close();	
	}
	
	public Cursor queryDB (String inputStream){
		db = dbHelper.getWritableDatabase();
		String[] columnNames = {"Hot", "Cold", "Mild", "Rain", "Sun", "Snow"};
		String[] parse = inputStream.split(",");
		Cursor cursor = db.query(
			ImagesDB.TABLE_IMAGES, columnNames,
			"where Hot=? Cold=? warm=? Waterproof=?",
			parse,null,null,null);
		return cursor;
	}
}
