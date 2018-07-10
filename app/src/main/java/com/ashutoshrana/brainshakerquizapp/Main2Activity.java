package com.ashutoshrana.brainshakerquizapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Main2Activity extends AppCompatActivity
{
    TextView timer,question,score_card,name;
    Button op1, op2, op3, op4;
    public int counter;
    static int scores=0;
    long time=30;
    int score=0;
    final int max=100;
    final int min=1;
    CountDownTimer obj=null;
    int i1,i2,i3,i4;
    int total_questions=0;
    int correct_answers =0;
    int choice_number=0;
    int score_temp;

    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        timer=findViewById(R.id.timer);
        question=findViewById(R.id.question);
        score_card=findViewById(R.id.score);
        name=findViewById(R.id.name);



        Question();

        obj=new CountDownTimer(30000, 1000)
        {



            public void onTick(long millisUntilFinished)
            {
                timer.setText(" " + millisUntilFinished / 1000+" ");
                time=millisUntilFinished / 1000;

            }

            @Override
            public void onFinish()
            {
                timer.setText(" 00 ");
                Toast.makeText(Main2Activity.this,"Time Up!",Toast.LENGTH_LONG).show();
                Intent intent = getIntent();
                final String player_name = intent.getStringExtra("player");

                Intent intent_score=new Intent(Main2Activity.this,ScoreBoard.class);
                intent_score.putExtra("score",String.valueOf(score));
                intent_score.putExtra("player",String.valueOf(player_name));
                intent_score.putExtra("questions",String.valueOf(total_questions));
                intent_score.putExtra("correct",String.valueOf(correct_answers));
                startActivity(intent_score);

                Main2Activity.this.finish();
            }
        };


    }
    void Question()
    {

        op1 =findViewById(R.id.button);
        op2 =findViewById(R.id.button2);
        op3 =findViewById(R.id.button3);
        op4 =findViewById(R.id.button4);


        r=new Random();
        int m=r.nextInt((max-min)+1)+min;
        int n=r.nextInt((max-min)+1)+min;
        String ques=Integer.toString(m)+" + "+Integer.toString(n);
        question.setText(ques);

        choice_number=r.nextInt((3))+1;
        i4=m+n;
        i1 = r.nextInt((max - min) + 1) ;
        i2 = r.nextInt((max - min) + 1) ;
        i3 = r.nextInt((max - min) + 1) ;
        switch(choice_number){

            case 1: op1.setText(Integer.toString(i4));
                    op2.setText(Integer.toString(i1));
                    op3.setText(Integer.toString(i2));
                    op4.setText(Integer.toString(i3));
                    op1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(total_questions==0)
                            obj.start();

                        if(time>0)
                        {
                            score_temp=Integer.parseInt((String) score_card.getText());
                            score_temp=score_temp+1;
                            score=score_temp;
                            score_card.setText(Integer.toString(score_temp));
                            total_questions=total_questions+1;
                            correct_answers=correct_answers+1;
                            Question();

                        }
                        else{
                            //get back
                            return;
                        }

                    }
                });

                op2.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(total_questions==0)
                            obj.start();
                        if(time>0){
                            score_temp=Integer.parseInt((String) score_card.getText());
                            total_questions=total_questions+1;
//                            score_temp=score_temp;
                            score=score_temp;
                            score_card.setText(Integer.toString(score_temp));
                            Question();
                        }
                        else
                            return;

                    }
                });

                op3.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(total_questions==0)
                            obj.start();
                        if(time>0){
                            int score_temp=Integer.parseInt((String) score_card.getText());
                            total_questions=total_questions+1;
//                            score_temp=score_temp-10;
                            score=score_temp;
                            score_card.setText(Integer.toString(score_temp));
                            Question();
                        }
                        else
                            return;

                    }
                });

                op4.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(total_questions==0)
                            obj.start();
                        if(time>0){
                            int score_temp=Integer.parseInt((String) score_card.getText());
                            total_questions=total_questions+1;
//                            score_temp=score_temp-10;
                            score=score_temp;
                            score_card.setText(Integer.toString(score_temp));
                            Question();
                        }
                        else
                            return;

                    }
                });
                break;

            case 2:     op2.setText(Integer.toString(i4));
                op1.setText(Integer.toString(i1));
                op3.setText(Integer.toString(i2));
                op4.setText(Integer.toString(i3));


                op2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        if(total_questions==0)
                            obj.start();
                        if(time>0)
                        {
                            int score_temp=Integer.parseInt((String) score_card.getText());
                            score_temp=score_temp+1;
                            score=score_temp;
                            score_card.setText(Integer.toString(score_temp));
                            total_questions=total_questions+1;
                            correct_answers=correct_answers+1;
                            Question();

                        }
                        else{
                            return;
                        }

                    }
                });

                op1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(total_questions==0)
                            obj.start();
                        if(time>0){
                            int score_temp=Integer.parseInt((String) score_card.getText());
                            total_questions=total_questions+1;
//                            score_temp=score_temp-10;
                            score=score_temp;
                            score_card.setText(Integer.toString(score_temp));
                            Question();

                        }
                        else
                            return;

                    }
                });

                op3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(total_questions==0)
                            obj.start();
                        if(time>0){
                            int score_temp=Integer.parseInt((String) score_card.getText());
                            total_questions=total_questions+1;
//                            score_temp=score_temp-10;
                            score=score_temp;
                            score_card.setText(Integer.toString(score_temp));
                            Question();

                        }
                        else
                            return;

                    }
                });

                op4.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(total_questions==0)
                            obj.start();
                        if(time>0){
                            int score_temp=Integer.parseInt((String) score_card.getText());
                            total_questions=total_questions+1;
//                            score_temp=score_temp-10;
                            score=score_temp;
                            score_card.setText(Integer.toString(score_temp));
                            Question();

                        }
                        else
                            return;

                    }
                });
                break;


            case 3: op3.setText(Integer.toString(i4));
                    op1.setText(Integer.toString(i1));
                    op2.setText(Integer.toString(i2));
                    op4.setText(Integer.toString(i3));


                op3.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(total_questions==0)
                            obj.start();
                        if(time>0)
                        {
                            int score_temp=Integer.parseInt((String) score_card.getText());
                            score_temp=score_temp+1;
                            score=score_temp;
                            score_card.setText(Integer.toString(score_temp));
                            total_questions=total_questions+1;
                            correct_answers=correct_answers+1;
                            Question();

                        }
                        else{
                            return;
                        }

                    }
                });
                op2.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(total_questions==0)
                            obj.start();
                        if(time>0){
                            int score_temp=Integer.parseInt((String) score_card.getText());
                            total_questions=total_questions+1;
//                            score_temp=score_temp-10;
                            score=score_temp;
                            score_card.setText(Integer.toString(score_temp));
                            Question();

                        }
                        else
                            return;

                    }
                });

                op1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(total_questions==0)
                            obj.start();
                        if(time>0){
                            int score_temp=Integer.parseInt((String) score_card.getText());
                            total_questions=total_questions+1;
//                            score_temp=score_temp-10;
                            score=score_temp;
                            score_card.setText(Integer.toString(score_temp));
                            Question();

                        }
                        else
                            return;

                    }
                });

                op4.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(total_questions==0)
                            obj.start();
                        if(time>0){
                            total_questions=total_questions+1;
                            Question();

                        }
                        else
                            return;

                    }
                });
                break;

            case 4: op4.setText(Integer.toString(i4));
                    op1.setText(Integer.toString(i1));
                    op2.setText(Integer.toString(i2));
                    op3.setText(Integer.toString(i3));


                    op4.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View V) {
                            if(total_questions==0)
                                obj.start();
                            if(time>0)
                            {
                                int score_temp=Integer.parseInt((String) score_card.getText());
                                score_temp=score_temp+1;
                                score=score_temp;
                                score_card.setText(Integer.toString(score_temp));
                                total_questions=total_questions+1;
                                correct_answers=correct_answers+1;
                                Question();

                            }
                            else{
                                return;
                            }

                        }
                    });

                    op2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View V) {
                            if(total_questions==0)
                                obj.start();
                            if(time>0){
                                int score_temp=Integer.parseInt((String) score_card.getText());
                                total_questions=total_questions+1;
//                                score_temp=score_temp-10;
                                score=score_temp;
                                score_card.setText(Integer.toString(score_temp));
                                Question();

                            }
                            else
                                return;

                        }
                    });

                    op3.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View V) {
                            if(total_questions==0)
                                obj.start();
                            if(time>0){
                                int score_temp=Integer.parseInt((String) score_card.getText());
                                total_questions=total_questions+1;
//                                score_temp=score_temp-10;
                                score=score_temp;
                                score_card.setText(Integer.toString(score_temp));
                                Question();

                            }
                            else
                                return;

                        }
                    });

                    op1.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View V) {
                            if(total_questions==0)
                                obj.start();
                            if(time>0){
                                int score_temp=Integer.parseInt((String) score_card.getText());
                                total_questions=total_questions+1;
//                                score_temp=score_temp-10;
                                score=score_temp;
                                score_card.setText(Integer.toString(score_temp));
                                Question();
                            }
                            else
                                return;

                        }
                    });
                    break;


            }

        }
}
