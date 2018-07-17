package com.ashutoshrana.brainshakerquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText name;
TextView msg;
Button start;
String temp=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.button10);

        name=findViewById(R.id.editText2);
        msg =findViewById(R.id.textView7);


        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError(" Name Required");
                    return;
                }else{
                    temp = name.getText().toString().trim();
                    Intent game = new Intent(MainActivity.this, Main2Activity.class);
                    game.putExtra("Name",temp);
                    startActivity(game);
                    finish();

                }



            }
        });
    }


}
