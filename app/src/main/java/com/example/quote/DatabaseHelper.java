package com.example.quote;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "favorite_quotes.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE favorite_quotes (_id INTEGER PRIMARY KEY, quote TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS favorite_quotes");
        onCreate(db);
    }

    public void addFavoriteQuote(String quote) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO favorite_quotes (quote) VALUES (?)", new String[]{quote});
        db.close();
    }

    public ArrayList<String> getFavoriteQuotes() {
        ArrayList<String> favoriteQuotes = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT quote FROM favorite_quotes", null);
        while (cursor.moveToNext()) {
            favoriteQuotes.add(cursor.getString(0));
        }
        cursor.close();
        db.close();
        return favoriteQuotes;
    }
}