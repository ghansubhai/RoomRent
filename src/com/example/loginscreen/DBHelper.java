package com.example.loginscreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

   public static final String DATABASE_NAME = "RoomRent.db";
   public static final String USERDETAILS_TABLE_NAME = "userdetails";
   public static final String USERDETAILS_COLUMN_EMAILADDRESS = "emailaddress";
   public static final String USERDETAILS_COLUMN_PASSWORD = "password";
   public static final String USERDETAILS_COLUMN_NAME = "name";
   public static final String USERDETAILS_COLUMN_PRIMARYPHONE = "primaryphone";
   public static final String USERDETAILS_COLUMN_ALTERNATEPHONES = "alternatephones";
   public static final String USERDETAILS_COLUMN_ADDRESSLINE = "addressline";
   public static final String USERDETAILS_COLUMN_CITY = "city";
   public static final String USERDETAILS_COLUMN_STATE = "state";
   public static final String USERDETAILS_COLUMN_PIN = "pin";
   public static final String USERDETAILS_COLUMN_USERTYPE = "usertype";

   private HashMap hp;

   public DBHelper(Context context)
   {
      super(context, DATABASE_NAME , null, 1);
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
      // TODO Auto-generated method stub
      db.execSQL(
      "create table userdetails " +
      "(emailaddress text primary key, password text,name text,primaryphone text, alternatephones text,addressline text,city text,state text,pin integer,usertype text)");
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      // TODO Auto-generated method stub
      db.execSQL("DROP TABLE IF EXISTS userdetails");
      onCreate(db);
   }

   public boolean insertUserDetails  (String emailaddress, String password, String name, String primaryphone,String alternatephones,String addressline,String city,String state,Integer pin,String usertype )
   {
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();

      contentValues.put("emailaddress", emailaddress);
      contentValues.put("password", password);
      contentValues.put("name", name);	
      contentValues.put("primaryphone", primaryphone);
      contentValues.put("alternatephones", alternatephones);
      contentValues.put("addressline", addressline);
      contentValues.put("city", city);
      contentValues.put("state", state);
      contentValues.put("pin", pin);
      contentValues.put("usertype",usertype);
      

      db.insert("userdetails", null, contentValues);
      return true;
   }
   public Cursor getData(String  emailaddress){
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor res =  db.rawQuery( "select * from userdetails where emailaddress="+emailaddress+"", null );
      return res;
   }
   public int numberOfRows(){
      SQLiteDatabase db = this.getReadableDatabase();
      int numRows = (int) DatabaseUtils.queryNumEntries(db, USERDETAILS_TABLE_NAME);
      return numRows;
   }
   public boolean updateUserDetails (String emailaddress, String password, String name, String primaryphone,String alternatephones,String addressline,String city,String state,Integer pin,String usertype)
   {
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put("emailaddress", emailaddress);
      contentValues.put("password", password);
      contentValues.put("name", name);	
      contentValues.put("primaryphone", primaryphone);
      contentValues.put("alternatephones", alternatephones);
      contentValues.put("addressline", addressline);
      contentValues.put("city", city);
      contentValues.put("state", state);
      contentValues.put("pin", pin);
      contentValues.put("usertype",usertype);
      db.update("userdetails", contentValues, "emailaddress = ? ", new String[] { emailaddress } );
      return true;
   }
   public boolean validateUser(String emailaddress, String password){
	   Cursor c = getReadableDatabase().rawQuery(
	            "SELECT * FROM " + USERDETAILS_TABLE_NAME + " WHERE "
	                    + USERDETAILS_COLUMN_EMAILADDRESS + "='" + emailaddress +"'AND "+USERDETAILS_COLUMN_PASSWORD+"='"+password+"'" ,  null);
	   if (c.getCount()>0)
	      return true;
	      return false;
	}

   public Integer deleteUserDetails (String emailaddress)
   {
      SQLiteDatabase db = this.getWritableDatabase();
      return db.delete("userdetails", "emailaddress = ? ", 
      new String[] {emailaddress});
   }
   
}