package com.example.jon.restroomradar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.google.android.gms.maps.model.Marker;

import javax.xml.validation.Schema;

/**
 * Created by Jon on 4/14/2015.
 */

public final class SchemaContract extends SQLiteOpenHelper{

    private static final String DB_NAME = "bathrooms.sqlite";
    private static final int VERSION = 1;

    public static final String TABLE_NAME = "location";
    public static final String COLUMN_LOCATION_TITLE = "title";
    public static final String COLUMN_LOCATION_DESCRIPTION = "description";
    public static final String COLUMN_LOCATION_LATITUDE = "latitude";
    public static final String COLUMN_LOCATION_LONGITUDE = "longitude";
    private static final String UID = "_id";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (" +
            UID + " integer primary key autoincrement, " +
            COLUMN_LOCATION_TITLE + " string," +
            COLUMN_LOCATION_DESCRIPTION + " string," +
            COLUMN_LOCATION_LATITUDE + " double," +
            COLUMN_LOCATION_LONGITUDE + " double);";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public SchemaContract(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COLUMN_LOCATION_TITLE + ", " + COLUMN_LOCATION_DESCRIPTION + ", " + COLUMN_LOCATION_LONGITUDE + ", " + COLUMN_LOCATION_LATITUDE + ") " +
                "VALUES ('test', 'test', '0.0', '0.0');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // implement schema changes and data massage here when upgrading
    }

    public double getLatitude(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_LOCATION_LATITUDE + " FROM " + TABLE_NAME + " WHERE " + UID + "=" + id + ";", null);
        if(cursor != null) cursor.moveToFirst();

        return cursor.getDouble(0);
    }

    public double getLongitude(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_LOCATION_LONGITUDE + " FROM " + TABLE_NAME + " WHERE " + UID + "=" + id + ";", null);
        if(cursor != null) cursor.moveToFirst();

        return cursor.getDouble(0);
    }

    public String getTitle(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_LOCATION_TITLE + " FROM " + TABLE_NAME + " WHERE " + UID + "=" + id + ";", null);
        if(cursor != null) cursor.moveToFirst();

        return cursor.getString(0);
    }
    public String getDescription(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_LOCATION_DESCRIPTION + " FROM " + TABLE_NAME + " WHERE " + UID + "=" + id + ";", null);
        if(cursor != null) cursor.moveToFirst();

        return cursor.getString(0);
    }

    public int getNumberEntries(){
        SQLiteDatabase db = this.getReadableDatabase();

        //Cursor cursor = db.rawQuery("SELECT " + UID + " FROM " + TABLE_NAME, null);
        //cursor.moveToLast();
        return 0;
                //cursor.getPosition();
    }

    public void setLatitude(int id, double latitude){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NAME + " SET " + COLUMN_LOCATION_LATITUDE + " = " + latitude + " WHERE " + UID + "=" + id + ";", null);
    }

    public void setLongitude(int id, double longitude){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NAME + " SET " + COLUMN_LOCATION_LONGITUDE + " = " + longitude + " WHERE " + UID + "=" + id + ";", null);
    }

    public void setTitle(int id, String title){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NAME + " SET " + COLUMN_LOCATION_TITLE + " = '" + title + "' WHERE " + UID + "=" + id + ";", null);
    }

    public void setDescription(int id, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NAME + " SET " + COLUMN_LOCATION_DESCRIPTION + " = '" + description + "' WHERE " + UID + "=" + id + ";", null);
    }

    public void newEntry(String title, String description, double longitude, double latitude)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COLUMN_LOCATION_TITLE + ", " + COLUMN_LOCATION_DESCRIPTION + ", " + COLUMN_LOCATION_LONGITUDE + ", " + COLUMN_LOCATION_LATITUDE + ") " +
                "VALUES ('" + title + "', '" + description + "', " + longitude + ", " + latitude + ");");
    }
}
