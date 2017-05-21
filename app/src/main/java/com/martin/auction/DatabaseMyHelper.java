package com.martin.auction;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 21.05.2017.
 */
public class DatabaseMyHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Product";
    public static final String TABLE_PRODUCT  = "Product";

    public static final String KEY_ID = "_id";
    public static final String KEY_PRODUCT = "product";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_PICTURE = "picture";

    public DatabaseMyHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_PRODUCT + " ("+ KEY_ID +
                " integer primary key, " + KEY_PRODUCT + " text, " + KEY_DESCRIPTION +
                " text, " + KEY_PICTURE + "blob)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_PRODUCT);
        onCreate(db);
    }
}
