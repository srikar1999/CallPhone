package com.example.phantom.callphone;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    SQLiteDatabase sdb;EditText e1,e2,e3,e4; Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent it =getIntent();
        final String s =it.getStringExtra("name");
         e1=(EditText)findViewById(R.id.editText7);
         e1.setText(s);
         e2=(EditText)findViewById(R.id.editText4);
         e3=(EditText)findViewById(R.id.editText8);
         e4=(EditText)findViewById(R.id.editText9);
         register =(Button)findViewById(R.id.button4);
         Intent i2=getIntent();
         e1.setText(i2.getStringExtra("name"));

         sdb=openOrCreateDatabase("CallPhone", MODE_PRIVATE, null);
         sdb.execSQL("create table if not exists Call(Name varchar(15),Rollno varchar(10),Phone varchar(10),Mail varchar(10))");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname =e1.getText().toString();
                String srollno=e2.getText().toString();
                String sphone =e3.getText().toString();
                String smail =e4.getText().toString();
                Intent it =new Intent(ThirdActivity.this,SecondActivity.class);
                it.putExtra("name",s);
                sdb.execSQL("insert into Call values('"+sname+"','"+srollno+"','"+sphone+"','"+smail+"')");
                Toast.makeText(getApplicationContext(), "Registered!", Toast.LENGTH_LONG);
                startActivity(it);
                  }
        });
    }
}
