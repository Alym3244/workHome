package com.example.workhome.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.workhome.R;

public class Other extends AppCompatActivity {
    Button btnLoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        btnLoad = (Button) findViewById(R.id.btn_Loadpaise);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Other.this,ViewPager.class);
                startActivity(intent);
            }
        });

        TextView t1,t2;
        t1 = findViewById(R.id.textView3);
        t2 = findViewById(R.id.textVie4);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String name = sp.getString("name","");
        String email = sp.getString("email","");
        t1.setText(name);
        t2.setText(email);

    }
}