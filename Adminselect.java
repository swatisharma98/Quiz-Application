package com.example.quizmain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Adminselect extends AppCompatActivity {
  Spinner sp2;
  String s;
  static  String s1;
    String name[]={"select Subject","Java","C","DSA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminselect);
        sp2 = (Spinner)findViewById(R.id.spinner2);

        ArrayAdapter<String> obj;
        obj=new ArrayAdapter<String>(Adminselect.this,R.layout.support_simple_spinner_dropdown_item,name);
        sp2.setAdapter(obj);

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s = (String)parent.getItemAtPosition(position);
                s1 = s;
                if(s.equals("Java")|| s.equals("C")||  s.equals("DSA"))
                {
                    Intent ii = new Intent(Adminselect.this,Admin_quiz.class);
                    startActivity(ii);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
