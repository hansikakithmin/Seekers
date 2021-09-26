package com.example.activitiestodo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="PackageInfo.db";

    public DBHelper(Context context) {super(context, DATABASE_NAME, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE"+UsersMaster.Packages.TABLE_NAME+"("+
                        UsersMaster.Packages._ID+"INTEGER PRIMARY KEY,"+
                        UsersMaster.Packages.COLUMN_NAME_SET_DATE+"TEXT,"+
                        UsersMaster.Packages.COLUMN_NAME_NUMBER_OF_PARTICIPANTS+"TEXT,"+
                        UsersMaster.Packages.COLUMN_NAME_PACKAGE_PRICE+"TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public Long addInfo(String set_date,String number_of_participants,String package_price){
        SQLiteDatabase db =  getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Packages.COLUMN_NAME_SET_DATE, set_date);
        values.put(UsersMaster.Packages.COLUMN_NAME_NUMBER_OF_PARTICIPANTS, number_of_participants);
        values.put(UsersMaster.Packages.COLUMN_NAME_PACKAGE_PRICE, package_price);

        return db.insert(UsersMaster.Packages.TABLE_NAME,null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
