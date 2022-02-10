package com.nire.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.Update;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nire.roomexample.database.AppDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static AppDatabase database;
    Button add_todo, read_todo, update_todo, delete_todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = Room.databaseBuilder(
                this,
                AppDatabase.class,
                "database"
        ).build();

        add_todo = findViewById(R.id.button_add);
        read_todo = findViewById(R.id.button_read);
        delete_todo = findViewById(R.id.button_delete);
        update_todo = findViewById(R.id.button_update);

        add_todo.setOnClickListener(this);
        read_todo.setOnClickListener(this);
        delete_todo.setOnClickListener(this);
        update_todo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button_add: {
                startActivity(new Intent(MainActivity.this, AddTodoActivity.class));
                break;
            }
            case R.id.button_read: {
                startActivity(new Intent(MainActivity.this, ReadTodoActivity.class));
                break;
            }
            case R.id.button_delete: {
                startActivity(new Intent(MainActivity.this, DeleteTodoActivity.class));
                break;
            }
            case R.id.button_update: {
                startActivity(new Intent(MainActivity.this, Update.class));
                break;
            }
        }
    }
}