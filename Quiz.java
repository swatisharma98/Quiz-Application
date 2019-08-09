package com.example.quizmain;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.quizmain.Login.id;
import static com.example.quizmain.Studinstr.s2;

public class Quiz extends AppCompatActivity {
TextView tt,tname;
   RadioButton r1,r2,r3,r4,r5;
   RadioGroup rag;
   String qno="Question";
   String javaans,cans,dsaans;
   static int countj,countq;
   int p =1,cc=1,d=1;
   TextView qu;
   Button sub;
   String sss;

   Quizdb obj;
    Cursor cp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        qu=(TextView)findViewById(R.id.textView2);
        tt=(TextView)findViewById(R.id.textView4);
        tname=(TextView)findViewById(R.id.textView10);
        r1 =(RadioButton)findViewById(R.id.radioButton2);
        r2 =(RadioButton)findViewById(R.id.radioButton3);
        r3 =(RadioButton)findViewById(R.id.radioButton4);
        rag =(RadioGroup)findViewById(R.id.rg) ;
        r4 =(RadioButton)findViewById(R.id.radioButton5);
        sub=(Button)findViewById(R.id.button);
        obj = new Quizdb(this);
        tname.setText(id);


        if(s2.equals("Java"))
        {
            try{ countj=0;
             cp = obj.set_quiz(p);
                cp.moveToFirst();
                if(cp.getCount() ==0)
                {
                    Toast.makeText(Quiz.this,"Finish ",Toast.LENGTH_LONG).show();
                    Intent n = new Intent(Quiz.this,Result.class);
                    startActivity(n);
                }else
                {
                    tt.setText(qno+" "+1);
                    countq++;
                    qu.setText(cp.getString(1));
                    r1.setText(cp.getString(2));
                    r2.setText(cp.getString(3));
                    r3.setText(cp.getString(4));
                    r4.setText(cp.getString(5));
                    javaans = cp.getString(6);
                }
            }catch(Exception c)
            {
            }
            sub.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int f = rag.getCheckedRadioButtonId();
                            r5 = (RadioButton)findViewById(f);
                            String st = r5.getText().toString();
                            if(st.equals(javaans))
                            {
                                countj++;
                            }
                            p++;
                            try {
                                tt.setText(qno+" "+p);
                                  cp = obj.set_quiz(p);
                                  cp.moveToFirst();
                                    if (cp.getCount() != 0) {
                                        qu.setText(cp.getString(1));
                                        r1.setText(cp.getString(2));
                                        r2.setText(cp.getString(3));
                                        r3.setText(cp.getString(4));
                                        r4.setText(cp.getString(5));
                                        javaans = cp.getString(6);

                                    } else {
                                        countq = p-1;
                                        Toast.makeText(Quiz.this, "Finish ", Toast.LENGTH_LONG).show();
                                        Intent n = new Intent(Quiz.this, Result.class);
                                        startActivity(n);
                                    }

                                } catch (Exception c) {
                                    Toast.makeText(Quiz.this, "Errorrr ", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
            );
        }

     else if(s2.equals("C"))
        {
            try{countj=0;
                countq=0;
                cp = obj.set_cquiz(cc);
                cp.moveToFirst();
                if(cp.getCount() == 0)
                {
                    Toast.makeText(Quiz.this,"No question ",Toast.LENGTH_LONG).show();
                    Intent n = new Intent(Quiz.this,Result.class);
                    startActivity(n);
                }else
                {
                    tt.setText(qno+" "+1);
                    qu.setText(cp.getString(1));
                    r1.setText(cp.getString(2));
                    r2.setText(cp.getString(3));
                    r3.setText(cp.getString(4));
                    r4.setText(cp.getString(5));
                    cans = cp.getString(6);
                }
            }catch(Exception c)
            {
            }
            sub.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int f = rag.getCheckedRadioButtonId();
                             r5= (RadioButton)findViewById(f);
                             String st = r5.getText().toString();
                             if(st.equals(cans))
                             {
                                 countj++;
                             }

                            cc++;
                            try {
                                tt.setText(qno+" "+cc);
                                cp = obj.set_cquiz(cc);
                                cp.moveToFirst();
                                if (cp.getCount() != 0) {

                                    qu.setText(cp.getString(1));
                                    r1.setText(cp.getString(2));
                                    r2.setText(cp.getString(3));
                                    r3.setText(cp.getString(4));
                                    r4.setText(cp.getString(5));
                                    cans = cp.getString(6);

                                } else {
                                         countq = cc-1;
                                    Toast.makeText(Quiz.this, "Last ques", Toast.LENGTH_LONG).show();
                                    Intent n = new Intent(Quiz.this, Result.class);
                                    startActivity(n);
                                }

                            } catch (Exception c) {
                                Toast.makeText(Quiz.this, "Errorrr ", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
            );
        }


       else if(s2.equals("DSA"))
        {
            try{countj=0;
                countq=0;
                cp = obj.set_dsquiz(d);
                cp.moveToFirst();
                if(cp.getCount() == 0)
                {
                    Toast.makeText(Quiz.this,"No question ",Toast.LENGTH_LONG).show();
                    Intent n = new Intent(Quiz.this,Result.class);
                    startActivity(n);
                }else
                {
                    tt.setText(qno+" "+1);
                    qu.setText(cp.getString(1));
                    r1.setText(cp.getString(2));
                    r2.setText(cp.getString(3));
                    r3.setText(cp.getString(4));
                    r4.setText(cp.getString(5));
                    dsaans = cp.getString(6);
                }
            }catch(Exception c)
            {
            }
            sub.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int f = rag.getCheckedRadioButtonId();
                            r5= (RadioButton)findViewById(f);
                            String st = r5.getText().toString();
                            if(st.equals(dsaans))
                            {
                                countj++;
                            }

                            d++;
                            try {
                                tt.setText(qno+" "+d);
                                cp = obj.set_dsquiz(d);
                                cp.moveToFirst();
                                if (cp.getCount() != 0) {

                                    qu.setText(cp.getString(1));
                                    r1.setText(cp.getString(2));
                                    r2.setText(cp.getString(3));
                                    r3.setText(cp.getString(4));
                                    r4.setText(cp.getString(5));
                                    dsaans = cp.getString(6);

                                } else {
                                          countq =d-1;
                                    Toast.makeText(Quiz.this, "Last ques", Toast.LENGTH_LONG).show();
                                    Intent n = new Intent(Quiz.this, Result.class);
                                    startActivity(n);
                                }

                            } catch (Exception c) {
                                Toast.makeText(Quiz.this, "Errorrr ", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
            );
        }


    }
}
