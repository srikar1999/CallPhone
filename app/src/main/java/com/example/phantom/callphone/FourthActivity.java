package com.example.phantom.callphone;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
   TextToSpeech tts;TextView t1,t2,t3,t4,t5; EditText e; Button search;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t5 = (TextView) findViewById(R.id.textView5);
        e = (EditText) findViewById(R.id.editText5);
        search =(Button)findViewById(R.id.button5);
       tts = new TextToSpeech(this,this);
        final SQLiteDatabase sdb = openOrCreateDatabase("CallPhone", MODE_PRIVATE, null);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = getIntent();
                String s = it1.getStringExtra("name");
                s = "Hello "+s;
                t5.setText(s);
                tts.speak(s, TextToSpeech.QUEUE_ADD, null);
                String s1 = e.getText().toString();
                Cursor c = sdb.rawQuery("select * from Call where Rollno ='" + s1 + "' ", null);
                if (c != null) {
                    c.moveToFirst();
                    do {
                        int a = c.getColumnIndex("Name");
                        int b = c.getColumnIndex("Rollno");
                        int d = c.getColumnIndex("Phone");
                        int e = c.getColumnIndex("Mail");
                        String a1 = c.getString(a);
                        String a2 = c.getString(b);
                        String a3 = c.getString(d);
                        String a4 = c.getString(e);
                        t1.setText(a1);
                        t2.setText(a2);
                        t3.setText(a3);
                        t4.setText(a4);
                    } while (c.moveToNext());
                }
            }

            ;


        });
    }
    @Override
    public void onInit( int status) {

    }
}
