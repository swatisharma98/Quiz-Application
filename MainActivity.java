package com.example.quizmain;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        t1 = (TextView)findViewById(R.id.textView8);
        setContentView(R.layout.activity_main);


        //Typeface myCustomFont =Typeface.createFromAsset(getAssets(), "fonts/Amazingkids.ttf");
        //t1.setTypeface(myCustomFont);

        Thread obj = new Thread()
        {
            public void run()
            {
                try {
                    sleep(4000);

                }
                catch (Exception t)
                {

                }
                finally {
                    Intent l;
                    l= new Intent(MainActivity.this,Login.class);
                    startActivity(l);
                    finish();
                }
            }
        };
        obj.start();
    }
}
