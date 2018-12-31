package com.example.dahiya.signtranslate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Databasehandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "videodatabase.db";
    public static final String TABLE_PRODUCTS = "videos";
    public static final String WORD = "word";
    public static final String URL = "url";

    public Databasehandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                        WORD + " TEXT PRIMARY KEY, " +
                        URL + " TEXT" +
                        ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addVideo(Video_structure v)
    {
        ContentValues values = new ContentValues();
        values.put(WORD, v.getWord());
        values.put(URL, v.getUrl());

        SQLiteDatabase db = getWritableDatabase();

        db.insert(TABLE_PRODUCTS, null, values);
//        Log.d("mytag1","addvideo func");
        db.close();
    }

    public void deleteVideo(String word, String url){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + WORD + "=\"" + word + "\" AND "  + URL + "=\""
                + url + "\";");
    }

    public Cursor getcursor()
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor cur=db.rawQuery("SELECT * FROM "+ TABLE_PRODUCTS,null);
        return cur;
    }

    public Cursor getcursorURL(String key)
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor cur=db.rawQuery("SELECT * FROM "+ TABLE_PRODUCTS + " WHERE "+ WORD+ "=" + "\""+ key + "\"",null);
        return cur;
    }

    public Cursor getcursorAlphabets(String alpha)
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor cur=db.rawQuery("SELECT * FROM "+ TABLE_PRODUCTS + " WHERE "+ WORD+ " LIKE " + "\""+ alpha + "%\"",null);
        return cur;
    }


}
