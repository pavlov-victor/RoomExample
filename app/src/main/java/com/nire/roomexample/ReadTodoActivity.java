package com.nire.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.nire.roomexample.adapters.TodoAdapter;
import com.nire.roomexample.database.Todo;

import java.util.List;

public class ReadTodoActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_todo);
        rv = findViewById(R.id.rec);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData() {
        class GetData extends AsyncTask<Void, Void, List<Todo>> {

            @Override
            protected List<Todo> doInBackground(Void... voids) {
                List<Todo> todos = MainActivity.database.todoDao().getTodo();
                return todos;
            }

            @Override
            protected void onPostExecute(List<Todo> todos) {
                TodoAdapter todoAdapter = new TodoAdapter(todos);
                rv.setAdapter(todoAdapter);
                super.onPostExecute(todos);
            }
        }
        GetData gd = new GetData();
        gd.execute();
    }
}