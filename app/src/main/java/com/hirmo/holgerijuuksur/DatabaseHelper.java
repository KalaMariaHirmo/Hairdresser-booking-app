package com.hirmo.holgerijuuksur;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static class FeedEntry implements BaseColumns {
        private static final String TABLE_NAME = "times_table";
        //private static final String COL1 = "ID";
        private static final String COL2 = "hairdresser";
        private static final String COL3 = "date";
        private static final String COL4 = "time";
        private static final String COL5 = "clientphonenumber";
        private static final String COL6 = "availability";
    }
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    //FeedEntry.COL1 + " INTEGER PRIMARY KEY," +
                    FeedEntry.COL2 + " TEXT," +
                    FeedEntry.COL3 + " TEXT," +
                    FeedEntry.COL4 + " TEXT," +
                    FeedEntry.COL5 + " INTEGER," +
                    FeedEntry.COL6 + " INTEGER)";


    public DatabaseHelper(Context context) {
        super(context, FeedEntry.TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    }
}
