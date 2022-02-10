package com.nire.roomexample.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoDao {

    @Query("select * from todo")
    public List<Todo> getTodo();

    @Insert
    public void addTodo(Todo todo);

    @Delete
    public void deleteTodo(Todo todo);

    @Update
    public void updateTodo(Todo todo);

    @Query("Select * FROM todo WHERE id=:id")
    public Todo getTodoById(Integer id);

}
