package com.ashutoshrana.brainshakerquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {
    TextView name,score;
    Button new_game,high_score;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        name=findViewById(R.id.textView5);
        score=findViewById(R.id.textView4);
        new_game=findViewById(R.id.button5);
        high_score=findViewById(R.id.button6);


        String score_new = getIntent().getStringExtra("Score"); //contains the score of present game
        String player_new = getIntent().getStringExtra("Name"); //contains the name of player
        final Integer answers_right = Integer.parseInt(getIntent().getStringExtra("Correct"));
        final Integer total_questions=Integer.parseInt(getIntent().getStringExtra("Questions"));


        score.setText(score_new);
        name.setText(player_new);




        new_game.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent game =new Intent(ScoreBoard.this,MainActivity.class);
                startActivity(game);
            }
        });

        high_score.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent hs =new Intent(ScoreBoard.this,HighScoreBoard.class);
                startActivity(hs);
            }
        });

    }
}
