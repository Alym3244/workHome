package com.example.workhome.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workhome.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TiarActivity extends AppCompatActivity {
Button btnAnimation;
    RecyclerView rvTask;
    RecyclerAdapter adapter;
    FloatingActionButton btnOpenAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnAnimation = findViewById(R.id.btn_animation);
        setContentView(R.layout.activity_tiar);
        rvTask= findViewById(R.id.rv_task);
        btnOpenAddTask = findViewById(R.id.btn_open_add_task);
        adapter= new RecyclerAdapter(this);
        rvTask.setAdapter(adapter);
        btnOpenAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TiarActivity.this, AddTaskActivity.class);
                startActivityForResult(intent,100);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    if(requestCode==100&& resultCode == RESULT_OK){
        String title = data.getStringExtra("title");
        String description = data.getStringExtra("description");
        TaskModel model = new TaskModel(title,description);
        adapter.addTask(model);
    }

    }
}