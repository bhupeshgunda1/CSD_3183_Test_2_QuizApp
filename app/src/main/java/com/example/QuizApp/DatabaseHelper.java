package com.example.QuizApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "test2";
    private static final String TABLE_CONTACTS = "quedetails";
    private static final String KEY_ID = "id";
    private static final String KEY_QUE = "QUESTION";
    private static final String KEY_ANS = "ANSWER";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        Log.d("-------Table created: ", DATABASE_NAME);
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"+ KEY_QUE + " TEXT,"
                + KEY_ANS + " TEXT"  +")";
        db.execSQL(CREATE_CONTACTS_TABLE);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        Log.d("-------Table created: ", TABLE_CONTACTS);
        String CREATE_QUIZ_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"+ KEY_QUE + " TEXT,"
                + KEY_ANS + " TEXT"  +")";
        db.execSQL(CREATE_QUIZ_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }
    void createQuizQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, question.get_id());
        values.put(KEY_QUE, question.getQuestion());
        values.put(KEY_ANS, question.getAnswer());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public int updateQuizQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, question.get_id());
        values.put(KEY_QUE, question.getQuestion());
        values.put(KEY_ANS, question.getAnswer());
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(question.getQuestion()) });
    }
    public int deleteQuizQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(question.getQuestion()) });
    }

}
