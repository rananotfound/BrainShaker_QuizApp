package com.ashutoshrana.brainshakerquizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class ScoreDataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "HIGHSCORE";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME = "ALLSCORE";
    public static final String CREATE_TABLE_OUTLET= "CREATE TABLE "+ TABLE_NAME + "(" +
            "Correct_Answer Integer, " +
            "Incorrect_Answer Integer, " +
            "Score Varchar, " +
            "Percentage Float, " +
            "Total_Question_Answered Integer)";
    public static final String DELETE_TABLE_OUTLET="DROP TABLE IF EXISTS " + TABLE_NAME;

    public ScoreDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_OUTLET);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DELETE_TABLE_OUTLET);

        onCreate(db);
    }

    public void addData(String correct_answer, String incorrect_answer, String score, Float percentage, String total_question_answered ){


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values;

        try
        {
            values = new ContentValues();
            values.put("Correct_Answer",correct_answer);
            values.put("Incorrect_Answer",incorrect_answer);
            values.put("Score",score);
            values.put("Percentage",percentage);
            values.put("Total_Question_Answered",total_question_answered);

            db.insert(TABLE_NAME+"", null, values);

        }
        catch (SQLiteException e)
        {
            e.printStackTrace();

        }


    }
    public Cursor getData()
    {
        SQLiteDatabase db =getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME+"",null,null,null,null,null,null);
        return  cursor;
    }


}
