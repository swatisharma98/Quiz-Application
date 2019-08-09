package com.example.quizmain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.quizmain.Adminselect.s1;

public class Admin_quiz extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6;
    String s2,q,o1,o2,o3,o4,A;

    Button subb;
    Quizdb obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_quiz);

        e1= (EditText)findViewById(R.id.editText6);
        e2= (EditText)findViewById(R.id.editText7);
        e3= (EditText)findViewById(R.id.editText8);
        e4= (EditText)findViewById(R.id.editText9);
        e5= (EditText)findViewById(R.id.editText10);
        e6= (EditText)findViewById(R.id.editText11);
        subb=(Button)findViewById(R.id.button4);
        s2 = s1;
        obj=new Quizdb(this);



          if (s2.equals("Java")) {
              subb.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      q = e1.getText().toString();
                      o1 = e2.getText().toString();
                      o2 = e3.getText().toString();
                      o3 = e4.getText().toString();
                      o4 = e5.getText().toString();
                      A = e6.getText().toString();
                      try {
                          obj.ad_quiz1(q, o1, o2, o3, o4, A);
                          Toast.makeText(Admin_quiz.this, "Data inserted", Toast.LENGTH_LONG).show();

                          e1.setText(null);
                          e2.setText(null);
                          e3.setText(null);
                          e4.setText(null);
                          e5.setText(null);
                          e6.setText(null);
                      } catch (Exception c) {
                          Toast.makeText(Admin_quiz.this, "not inserted", Toast.LENGTH_LONG).show();
                      }

                  }
              });
          }
          else if(s2.equals("C"))
          {
              subb.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      q = e1.getText().toString();
                      o1 = e2.getText().toString();
                      o2 = e3.getText().toString();
                      o3 = e4.getText().toString();
                      o4 = e5.getText().toString();
                      A = e6.getText().toString();
                      try {
                          obj.ad_cquiz(q, o1, o2, o3, o4, A);
                          Toast.makeText(Admin_quiz.this, "Data inserted", Toast.LENGTH_LONG).show();
                          e1.setText(null);
                          e2.setText(null);
                          e3.setText(null);
                          e4.setText(null);
                          e5.setText(null);
                          e6.setText(null);
                      } catch (Exception c) {
                          Toast.makeText(Admin_quiz.this, "not inserted", Toast.LENGTH_LONG).show();
                      }

                  }
              });
          }

         else if(s2.equals("DSA"))
          {
              subb.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      q = e1.getText().toString();
                      o1 = e2.getText().toString();
                      o2 = e3.getText().toString();
                      o3 = e4.getText().toString();
                      o4 = e5.getText().toString();
                      A = e6.getText().toString();
                      try {
                          obj.ad_dsaquiz(q, o1, o2, o3, o4, A);
                          Toast.makeText(Admin_quiz.this, "Data inserted", Toast.LENGTH_LONG).show();

                          e1.setText(null);
                          e2.setText(null);
                          e3.setText(null);
                          e4.setText(null);
                          e5.setText(null);
                          e6.setText(null);
                      } catch (Exception c) {
                          Toast.makeText(Admin_quiz.this, "not inserted", Toast.LENGTH_LONG).show();
                      }

                  }
              });
          }


    }
}
