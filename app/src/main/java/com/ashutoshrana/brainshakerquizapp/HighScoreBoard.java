package com.ashutoshrana.brainshakerquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class HighScoreBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_board);

        TableLayout mylist=(TableLayout) findViewById(R.id.table_lay);

    }
}
