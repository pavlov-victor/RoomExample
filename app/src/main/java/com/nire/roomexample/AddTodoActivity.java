package com.nire.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nire.roomexample.database.Todo;

public class AddTodoActivity extends AppCompatActivity {
    Button button_save;
    EditText todo_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        button_save = findViewById(R.id.button_save);
        todo_text = findViewById(R.id.task_name);

        button_save.setOnClickListener(view -> {
            String taskName = todo_text.getText().toString();
            Todo todo = new Todo();
            todo.setName(taskName);
            new Thread(()->{
                MainActivity.database.todoDao().addTodo(todo);
            }).start();
            Toast.makeText(getApplicationContext(), "Todo saved", Toast.LENGTH_LONG).show();
            todo_text.setText("");
        });
    }
}