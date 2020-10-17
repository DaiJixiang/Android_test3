package com.example.test3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context,"exp3.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table userInfo(_id integer primary key autoincrement,userName " +
                "varchar,password varchar,name varchar,age varchar,birthday varchar," +
                "phoneNumber varchar)";
        Log.i("TAG:","创建userInfo数据库表！");
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
