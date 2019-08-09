package com.example.quizmain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.quizmain.Quiz.countj;
import static com.example.quizmain.Quiz.countq;


public class Result extends AppCompatActivity {
  TextView t1,t2;
  String ss,ss1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1 = (TextView)findViewById(R.id.textView5);
        t2=(TextView)findViewById(R.id.textView7);

        ss = String.valueOf(countj);
        ss1 = String.valueOf(countq);

        t1.setText(ss);
        t2.setText(ss1);



    }
}
