package com.example.workhome.fragment;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.workhome.R;

public class IntelbohAmdLohActivity extends AppCompatActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intelboh_amd_loh);
        b =(Button) findViewById(R.id.android1);
     //   AnimationUtils.loadAnimation(this,)
    }
}