package com.nire.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.nire.roomexample.database.Todo;


public class DeleteTodoActivity extends AppCompatActivity {
    Button buttonDelete;
    EditText todoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_todo);
        todoId = findViewById(R.id.edit_id);
        buttonDelete = findViewById(R.id.todo_delete);

        buttonDelete.setOnClickListener((e) -> {
            deleteTodo();
        });
    }

    private void deleteTodo() {
        class DeleteData extends AsyncTask<Void, Void, Todo> {
            @Override
            protected Todo doInBackground(Void... voids) {
                Integer id = Integer.parseInt(todoId.getText().toString());
                Todo todo = MainActivity.database.todoDao().getTodoById(id);
                MainActivity.database.todoDao().deleteTodo(todo);
                return todo;
            }

        }
        DeleteData dd = new DeleteData();
        dd.execute();
    }
}