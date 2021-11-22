package com.example.workhome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.workhome.fragment.Other;


public class MainActivity extends AppCompatActivity {
    EditText name,email;
    Button button,button2;
    SharedPreferences sp;
    String nameStr,emailStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.EditText1);
        email = findViewById(R.id.EditText2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameStr = name.getText().toString();
                emailStr = email.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name",nameStr);
                editor.putString("email",emailStr);
                editor.commit();
                Toast.makeText(MainActivity.this ,"Information Saved", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Other.class);
                startActivity(intent);
            }
        });

    }
}