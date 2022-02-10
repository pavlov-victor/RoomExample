package com.nire.roomexample.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nire.roomexample.R;
import com.nire.roomexample.database.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    List<Todo> todos;

    public TodoAdapter(List<Todo> todos) {
        this.todos = todos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.textId.setText("" + todo.getId());
        holder.textName.setText(todo.getName());
        holder.textCompleted.setText("" + todo.getCompleted());
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textId, textName, textCompleted;

        public ViewHolder(@NonNull View todoView) {
            super(todoView);
            textId = todoView.findViewById(R.id.text_id);
            textName = todoView.findViewById(R.id.text_name);
            textCompleted = todoView.findViewById(R.id.text_completed);
        }

    }
}
