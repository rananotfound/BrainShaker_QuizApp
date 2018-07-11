package com.ashutoshrana.brainshakerquizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ScoreDataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "HIGHSCORE";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "ALLSCORE";
    public static final String CREATE_TABLE_OUTLET= "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME + "(Correct_Answer Integer, Incorrect_Answer Integer, Score Varchar, Percentage Float, Toatal_Question_Answered Integer)";
    public static final String DELETE_TABLE_OUTLET="DROP TABLE IF EXISTS " + TABLE_NAME;

    public ScoreDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_OUTLET);

    }
    //Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DELETE_TABLE_OUTLET);
        //Create tables again
        onCreate(db);
    }

    public void addData(String correct_answer, String incorrect_answer, String score, String percentage, String total_question_answered ){

        // Open the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // Start the transaction.
        db.beginTransaction();
        ContentValues values;

        try
        {
            values = new ContentValues();
            values.put("Correct_Answer",correct_answer);
            values.put("Incorrect_Answer",incorrect_answer);
            values.put("Score",score);
            values.put("Percentage",percentage);
            values.put("Total_Question_Answered",total_question_answered);
            // Insert Row
            db.insert(TABLE_NAME, null, values);
//            Log.i("Insert", i + "");
            // Insert into database successfully.
            db.setTransactionSuccessful();


        }
        catch (SQLiteException e)
        {
            e.printStackTrace();

        }
        finally
        {
            db.endTransaction();
            // End the transaction.
            db.close();
            // Close database
        }

    }
    public Cursor getData()
    {
        SQLiteDatabase db =getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME+"",null,null,null,null,null,null);
        return  cursor;
    }


}
