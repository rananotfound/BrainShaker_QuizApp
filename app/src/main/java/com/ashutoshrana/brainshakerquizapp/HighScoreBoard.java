package com.ashutoshrana.brainshakerquizapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class HighScoreBoard extends AppCompatActivity {

    ArrayList<Score> arrayList;
    MyAdapter myAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_board);



        ScoreDataBase scoreDataBase = new ScoreDataBase(HighScoreBoard.this);
        Cursor cursor = scoreDataBase.getData();

        arrayList = new ArrayList<Score>();

        if(cursor.moveToFirst())

        {
            do
            {
                String correct_answer=cursor.getString(cursor.getColumnIndex("Correct_Answer"));
                String incorrect_answer=cursor.getString(cursor.getColumnIndex("Incorrect_Answer"));
                String score=cursor.getString(cursor.getColumnIndex("Score"));
                String percentage=cursor.getString(cursor.getColumnIndex("Percentage"));
                String total_question_answered=cursor.getString(cursor.getColumnIndex("Total_Question_Answered"));

                Score finalValue = (new Score(correct_answer + " " , incorrect_answer + " " , score + " ",percentage+" ", ""+total_question_answered));

                Log.d("test", String.valueOf(finalValue));

                arrayList.add(finalValue);
            }
            while (cursor.moveToNext());
        }

        recyclerView = findViewById(R.id.list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this,arrayList);
        recyclerView.setAdapter(myAdapter);



    }
}


//