package com.example.dam2_ordinario;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDOrdSQLiteAdmin extends SQLiteOpenHelper {
    public BDOrdSQLiteAdmin (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table productos(id integer primary key autoincrement, name text, price text, unitys text, imgs text, fecha DATE default(datetime('now', 'localtime')))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
