package com.example.quizmain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
  Button register;
  EditText id,name,pass;
  Quizdb obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        register = (Button)findViewById(R.id.button3);
        id =(EditText) findViewById(R.id.ed1);
        name =(EditText) findViewById(R.id.ed2);
        pass=(EditText) findViewById(R.id.ed3);

        obj =new Quizdb(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id1 = id.getText().toString();

                String s2 = name.getText().toString();
                String s3 = pass.getText().toString();
                try{
                    int s1 = Integer.parseInt(id1);
                    obj.add(s1,s2,s3);

                    Toast.makeText(Registration.this,"added data",Toast.LENGTH_LONG).show();
                }catch(Exception e)
                {
                    Toast.makeText(Registration.this,"error ",Toast.LENGTH_LONG).show();
                }


                Intent ob = new Intent(Registration.this,Login.class);
                startActivity(ob);
            }
        });
    }
}
