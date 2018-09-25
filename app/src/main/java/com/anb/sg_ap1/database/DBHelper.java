package com.anb.sg_ap1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.anb.sg_ap1.model.User;

// Creating Database
public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "sg_android.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Buat tabel database Student
        String CREATE_TABLE_USER = "CREATE TABLE " + User.TABLE  + "("
                + User.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + User.KEY_nama + " TEXT, "
                + User.KEY_umur + " INTEGER, "
                + User.KEY_gender + " TEXT )";

        db.execSQL(CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Menghapus versi lama database
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE);
    }
}
