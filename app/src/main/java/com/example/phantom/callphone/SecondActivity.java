package com.example.phantom.callphone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EditText e=(EditText)findViewById(R.id.editText);
        EditText e2=(EditText)findViewById(R.id.editText3);
        Button login=(Button)findViewById(R.id.button);
        Button newuser=(Button)findViewById(R.id.button3);
        Intent it2=getIntent();
       final String s=it2.getStringExtra("name");
        e.setText(s);
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent it =new Intent(SecondActivity.this,ThirdActivity.class);
              it.putExtra("name", s);
              startActivity(it);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(SecondActivity.this,FourthActivity.class);
                it.putExtra("name", s);
                startActivity(it);
            }
        });
    }
}
