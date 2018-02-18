package com.hostel9.android.hostel9app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.hostel9.android.hostel9app.model.Mess;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 26/1/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MessManager";

    // Table Names
    private static final String TABLE_MESS = "Mess";


    // Common column names
    private static final String ID = "id";
    private static final String DAY = "day";
    private static final String BREAK1 = "break1";
    private static final String BREAK2 = "break2";
    private static final String LUNCH1 = "lunch1";
    private static final String LUNCH2 = "lunch2";
    private static final String TIFFIN1 = "tiffin1";
    private static final String TIFFIN2 = "tiffin2";
    private static final String DINNER1 = "dinner1";
    private static final String DINNER2 = "dinner2";
    private static final String MESS_ID = "mess_id";
    
    
////
////    private static final String KEY_TYPE = "type";
//
//    // NOTES Table - column names
//    private static final String KEY_NAME = "name";
////    private static final String KEY_SUBTITLE = "subtitle";
//    private static final String KEY_SWITCH_TYPE = "switchtype";
////    private static final String KEY_TIME_START = "starttime";
////    private static final String KEY_TIME_END = "endtime";
////    private static final String KEY_VENUE = "venue";
////    private static final String KEY_GOING = "going";
//    private static final String KEY_SWITCH_ID = "switch_id";
//    private static final String KEY_IS_ON = "is_on";





    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_MESS = "CREATE TABLE "
            + TABLE_MESS + "(" + ID + " INTEGER PRIMARY KEY," + DAY + " TEXT," + MESS_ID + " INTEGER," + BREAK1 + " TEXT," + BREAK2
            + " TEXT," + LUNCH1 +" TEXT," + LUNCH2 + " TEXT," + TIFFIN1 + " TEXT," + TIFFIN2 + " TEXT," + DINNER1 + " TEXT," + DINNER2 + " TEXT"+")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_MESS);
        Log.i("mess", "done");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESS);

        // create new tables
        onCreate(db);
    }

    /*
 * Creating a mess
 */
    public long createMess(Mess mess) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MESS_ID, mess.getId());
        values.put(DAY, mess.getDay());
        values.put(BREAK1, mess.getBreak1());
        values.put(BREAK2, mess.getBreak2());
        values.put(LUNCH1, mess.getLunch1());
        values.put(LUNCH2, mess.getLunch2());
        values.put(TIFFIN1, mess.getTiffin1());
        values.put(TIFFIN2, mess.getTiffin2());
        values.put(DINNER1, mess.getDinner1());
        values.put(DINNER2, mess.getDinner2());

        // insert row
        return db.insert(TABLE_MESS, null, values);
    }

    /*
 * get single MENU
 */
    public Mess getMess(long mess_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_MESS + " WHERE "
                + ID + " = " +mess_id;

        //Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        Mess mess = new Mess();
        if (c.moveToFirst()) {
            mess.setId(c.getInt(c.getColumnIndex(MESS_ID)));
            mess.setDay(c.getString(c.getColumnIndex(DAY)));
            mess.setBreak1((c.getString(c.getColumnIndex(BREAK1))));
            mess.setBreak2((c.getString(c.getColumnIndex(BREAK2))));
            mess.setLunch1(c.getString(c.getColumnIndex(LUNCH1)));
            mess.setLunch2((c.getString(c.getColumnIndex(LUNCH2))));
            mess.setTiffin1(c.getString(c.getColumnIndex(TIFFIN1)));
            mess.setTiffin2((c.getString(c.getColumnIndex(TIFFIN2))));
            mess.setDinner1((c.getString(c.getColumnIndex(DINNER1))));
            mess.setDinner2(c.getString(c.getColumnIndex(DINNER2)));

        }

        return mess;
    }
    public void updateMessifFound(Mess mess) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_MESS + " WHERE "
                + MESS_ID + " = " + mess.getId();

        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            if (c.moveToFirst()) {

                Mess mess1 = new Mess();

                mess1.setId(c.getInt(c.getColumnIndex(ID)));
//                mess1.setGoing((c.getInt(c.getColumnIndex(KEY_GOING))));

                db.delete(TABLE_MESS, ID + " = ?",
                        new String[]{String.valueOf(mess1.getId())});

                ContentValues values = new ContentValues();
                values.put(MESS_ID, mess.getId());
                values.put(DAY, mess.getDay());
                values.put(BREAK1, mess.getBreak1());
                values.put(BREAK2, mess.getBreak2());
                values.put(LUNCH1, mess.getLunch1());
                values.put(LUNCH2, mess.getLunch2());
                values.put(TIFFIN1, mess.getTiffin1());
                values.put(TIFFIN2, mess.getTiffin2());
                values.put(DINNER1, mess.getDinner1());
                values.put(DINNER2, mess.getDinner2());

                db.insert(TABLE_MESS, null, values);

            } else {
                ContentValues values = new ContentValues();
                values.put(MESS_ID, mess.getId());
                values.put(DAY, mess.getDay());
                values.put(BREAK1, mess.getBreak1());
                values.put(BREAK2, mess.getBreak2());
                values.put(LUNCH1, mess.getLunch1());
                values.put(LUNCH2, mess.getLunch2());
                values.put(TIFFIN1, mess.getTiffin1());
                values.put(TIFFIN2, mess.getTiffin2());
                values.put(DINNER1, mess.getDinner1());
                values.put(DINNER2, mess.getDinner2());

                // insert row
                db.insert(TABLE_MESS, null, values);

            }
        }
    }

    /*
 * getting all messs
 * */

    public List<Mess> getAllMesses() {
        List<Mess> messs = new ArrayList<Mess>();
        String selectQuery = "SELECT  * FROM " + TABLE_MESS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Mess mess = new Mess();
                mess.setId(c.getInt(c.getColumnIndex(MESS_ID)));
                mess.setDay(c.getString(c.getColumnIndex(DAY)));
                mess.setBreak1((c.getString(c.getColumnIndex(BREAK1))));
                mess.setBreak2((c.getString(c.getColumnIndex(BREAK2))));
                mess.setLunch1(c.getString(c.getColumnIndex(LUNCH1)));
                mess.setLunch2((c.getString(c.getColumnIndex(LUNCH2))));
                mess.setTiffin1(c.getString(c.getColumnIndex(TIFFIN1)));
                mess.setTiffin2((c.getString(c.getColumnIndex(TIFFIN2))));
                mess.setDinner1((c.getString(c.getColumnIndex(DINNER1))));
                mess.setDinner2(c.getString(c.getColumnIndex(DINNER2)));
                // adding to mess list
                messs.add(mess);
            } while (c.moveToNext());
        }

        return messs;
    }

    /*
 * getting all messs under single tag
 * */

    /*
     * Updating a mess
     */
    public int updateMess(Mess mess) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MESS_ID, mess.getId());
        values.put(DAY, mess.getDay());
        values.put(BREAK1, mess.getBreak1());
        values.put(BREAK2, mess.getBreak2());
        values.put(LUNCH1, mess.getLunch1());
        values.put(LUNCH2, mess.getLunch2());
        values.put(TIFFIN1, mess.getTiffin1());
        values.put(TIFFIN2, mess.getTiffin2());
        values.put(DINNER1, mess.getDinner1());
        values.put(DINNER2, mess.getDinner2());


        // updating row
        return db.update(TABLE_MESS, values, ID + " = ?",
                new String[]{String.valueOf(mess.getId())});
    }
    public void deleteMess(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MESS, ID + " = ?",
                new String[]{String.valueOf(id)});


    }


    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
