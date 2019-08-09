package com.example.quizmain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Studinstr extends AppCompatActivity {
   Spinner spp;
   String s;
   static String s2;
    String name[]={"Select Subject","Java","C","DSA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studinstr);

        spp = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> obj;
        obj=new ArrayAdapter<String>(Studinstr.this,R.layout.support_simple_spinner_dropdown_item,name);
        spp.setAdapter(obj);

        spp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s = (String)parent.getItemAtPosition(position);
                s2 =s;
                if(s.equals("Java")|| s.equals("C")|| s.equals("DSA"))
                {
                    Intent ii = new Intent(Studinstr.this,Quiz.class);
                    startActivity(ii);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }
}
