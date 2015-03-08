package com.callitself.database;

import java.util.List;

import com.callitself.model.Messages;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
	private DatabaseHelper helper = null;
	private SQLiteDatabase db = null;

	public DatabaseManager(Context context) {
		// TODO Auto-generated constructor stub
		helper = new DatabaseHelper(context);
		db = helper.getWritableDatabase();
	}
	
	public void insert(List<Messages> contants){
		
	}
}
