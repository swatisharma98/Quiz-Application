package com.example.quizmain;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button b1,b2;
    EditText e,e2;
    String s1,s2;
    TextView t1;
    Quizdb obj;
    static String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b2= (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button2);
        t1 = (TextView) findViewById(R.id.textView3);
        e = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        obj=new Quizdb(this);

         id =e.getText().toString();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e.getText().toString();
                s2 = e2.getText().toString();
                int x =Integer.parseInt(s1);
                try {
                    Cursor c  = obj.login(x,s2);
                    if(s1.isEmpty() || s2.isEmpty())
                    {
                        Toast.makeText(Login.this,"please enter details",Toast.LENGTH_LONG).show();
                    }else if(c.getCount() == 0){
                        Toast.makeText(Login.this,"Data not found",Toast.LENGTH_LONG).show();
                    }else{
                        c.moveToFirst();
                        int idd = c.getInt(0);
                        String password = c.getString(2);
                        if(idd == x && password.equals(s2))
                        {
                            Toast.makeText(Login.this,"login successful",Toast.LENGTH_LONG).show();
                            Intent in = new Intent(Login.this,Studinstr.class);
                            startActivity(in);
                        }
                    }
                } catch (Exception c) {
                    Toast.makeText(Login.this, "error = "+c, Toast.LENGTH_LONG).show();
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(Login.this, Registration.class);
                startActivity(obj);
            }
        });


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e.getText().toString();
                s2 = e2.getText().toString();
                if (s1.equals("1234") && s2.equals("admin")) {

                        Intent ii = new Intent(Login.this, Adminselect.class);
                        startActivity(ii);

                }else {
                    Toast.makeText(Login.this,"Username and password not correct",Toast.LENGTH_LONG).show();
                }
            }
        });




    }
}