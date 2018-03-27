package com.hostel9.android.hostel9app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hostel9.android.hostel9app.model.Event;
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
    private static final String DATABASE_NAME = "MessEventManager";

    // Table Names
    private static final String TABLE_MESS = "Mess";
    private static final String TABLE_EVENT = "Event";


    //  column names for Mess
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


    // NOTES Table - column names for event
    private static final String KEY_NAME = "name";
    private static final String KEY_GENRE = "genre";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_TIME_START = "starttime";
    private static final String KEY_DATE = "date";
    private static final String KEY_VENUE = "venue";
    private static final String KEY_EVENT_ID = "event_id";
    private static final String KEY_IMAGE_URL = "image_url";





    // Table Create Statements
    // Todo table create statement MEss
    private static final String CREATE_TABLE_MESS = "CREATE TABLE "
            + TABLE_MESS + "(" + ID + " INTEGER PRIMARY KEY," + DAY + " TEXT," + MESS_ID + " INTEGER," + BREAK1 + " TEXT," + BREAK2
            + " TEXT," + LUNCH1 +" TEXT," + LUNCH2 + " TEXT," + TIFFIN1 + " TEXT," + TIFFIN2 + " TEXT," + DINNER1 + " TEXT," + DINNER2 + " TEXT"+")";


    private static final String CREATE_TABLE_EVENT = "CREATE TABLE "
            + TABLE_EVENT + "(" + ID + " INTEGER PRIMARY KEY," + KEY_EVENT_ID + " INTEGER," + KEY_NAME + " TEXT," + KEY_GENRE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_VENUE +" TEXT," + KEY_DATE + " TEXT," + KEY_TIME_START + " TEXT," + KEY_IMAGE_URL + " TEXT"+")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_MESS);
        db.execSQL(CREATE_TABLE_EVENT);
        Log.i("mess AND EVENT TABLES", "done");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);

        // create new tables
        onCreate(db);
    }

    public void upgradeEvent() {
        // on upgrade drop older tables
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
        db.execSQL(CREATE_TABLE_EVENT);

        // create new tables

    }

    public void upgradeMess() {
        // on upgrade drop older tables
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESS);
        db.execSQL(CREATE_TABLE_MESS);

        // create new tables

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

    // creating an event and storing in the database. no need to add sql id to the content values. will be generated
    // automatically. it is also returned in the function.

    public long createEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EVENT_ID, event.getId());
        values.put(KEY_NAME, event.getName());
        values.put(KEY_GENRE, event.getGenre());
        values.put(KEY_DESCRIPTION, event.getDescription());
        values.put(KEY_VENUE, event.getVenue());
        values.put(KEY_DATE, event.getDate());
        values.put(KEY_TIME_START, event.getTime());
        values.put(KEY_IMAGE_URL, event.getImage_url());

        // insert row
        return db.insert(TABLE_EVENT, null, values);
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
    
    public Event getEvent(long event_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_EVENT + " WHERE "
                + KEY_EVENT_ID + " = " +event_id;

        //Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        Event event = new Event();
        if (c.moveToFirst()) {
            event.setId(c.getInt(c.getColumnIndex(KEY_EVENT_ID)));
            event.setName(c.getString(c.getColumnIndex(KEY_NAME)));
            event.setGenre(c.getString(c.getColumnIndex(KEY_GENRE)));
            event.setDescription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
            event.setVenue((c.getString(c.getColumnIndex(KEY_VENUE))));
            event.setDate(c.getString(c.getColumnIndex(KEY_DATE)));
            event.setTime((c.getString(c.getColumnIndex(KEY_TIME_START))));
            event.setImage_url(c.getString(c.getColumnIndex(KEY_IMAGE_URL)));
            event.setSqlId((c.getInt(c.getColumnIndex(ID))));

        }

        return event;
    }

    public void updateMessifFound(Mess mess) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_MESS + " WHERE "
                + MESS_ID + " = " + mess.getId();

        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            if (c.moveToFirst()) {

                Mess mess1 = new Mess();

                mess1.setDay(c.getString(c.getColumnIndex(DAY)));
//                mess1.setGoing((c.getInt(c.getColumnIndex(KEY_GOING))));

                db.delete(TABLE_MESS, DAY + " = ?",
                        new String[]{String.valueOf(mess1.getDay())});

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

// updating event
    public void updateEventifFound(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_EVENT + " WHERE "
                + KEY_EVENT_ID + " = " + event.getId();

        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            if (c.moveToFirst()) {

                Event event1 = new Event();

                event1.setId(c.getInt(c.getColumnIndex(KEY_EVENT_ID)));
//                event1.setGoing((c.getInt(c.getColumnIndex(KEY_GOING))));

                db.delete(TABLE_EVENT, KEY_EVENT_ID + " = ?",
                        new String[]{String.valueOf(event1.getId())});

                ContentValues values = new ContentValues();
                values.put(KEY_EVENT_ID, event.getId());
                values.put(KEY_NAME, event.getName());
                values.put(KEY_GENRE, event.getGenre());
                values.put(KEY_DESCRIPTION, event.getDescription());
                values.put(KEY_VENUE, event.getVenue());
                values.put(KEY_DATE, event.getDate());
                values.put(KEY_TIME_START, event.getTime());
                values.put(KEY_IMAGE_URL, event.getImage_url());

                db.insert(TABLE_EVENT, null, values);

            } else {
                ContentValues values = new ContentValues();
                values.put(KEY_EVENT_ID, event.getId());
                values.put(KEY_NAME, event.getName());
                values.put(KEY_GENRE, event.getGenre());
                values.put(KEY_DESCRIPTION, event.getDescription());
                values.put(KEY_VENUE, event.getVenue());
                values.put(KEY_DATE, event.getDate());
                values.put(KEY_TIME_START, event.getTime());
                values.put(KEY_IMAGE_URL, event.getImage_url());

                // insert row
                db.insert(TABLE_EVENT, null, values);

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
// GET THE LIST OF EVENTS

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<Event>();
        String selectQuery = "SELECT  * FROM " + TABLE_EVENT;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Event event = new Event();
                event.setId(c.getInt(c.getColumnIndex(KEY_EVENT_ID)));
                event.setName(c.getString(c.getColumnIndex(KEY_NAME)));
                event.setGenre(c.getString(c.getColumnIndex(KEY_GENRE)));
                event.setDescription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
                event.setVenue((c.getString(c.getColumnIndex(KEY_VENUE))));
                event.setDate(c.getString(c.getColumnIndex(KEY_DATE)));
                event.setTime((c.getString(c.getColumnIndex(KEY_TIME_START))));
                event.setImage_url(c.getString(c.getColumnIndex(KEY_IMAGE_URL)));
                event.setSqlId((c.getInt(c.getColumnIndex(ID))));
                // adding to event list
                events.add(event);
            } while (c.moveToNext());
        }

        return events;
    }

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
