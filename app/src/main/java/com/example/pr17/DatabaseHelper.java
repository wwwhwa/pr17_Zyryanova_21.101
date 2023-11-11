package com.example.pr17;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import java.sql.PreparedStatement;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "meowstore.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "meow"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_BREED = "breed";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "INSERT INTO " + TABLE + " (" + COLUMN_NAME + ", " + COLUMN_BREED + ") VALUES (?, ?)";
        db.execSQL("CREATE TABLE meow (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + " TEXT, " + COLUMN_BREED + " TEXT);");
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_BREED  + ") VALUES ('Scottish', 'scottish strite');");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}