package com.sumerge.todolist.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Task {
    private Long id;
    private String title;
    private String body;
    private boolean isCompleted;
    private static Long idCounter = 0L;


    public Task(String title, boolean isCompleted) {
        this.id = generateId();
        this.title = title;
        this.body = "";
        this.isCompleted = isCompleted;
    }
    public Task(String title, String body, boolean isCompleted) {
        this.id = generateId();
        this.title = title;
        this.body = body;
        this.isCompleted = isCompleted;
    }
    public Long generateId(){
        return ++idCounter;
    }

}
