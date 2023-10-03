package com.sumerge.todolist.services;

import com.sumerge.todolist.models.Task;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class TaskService {

    List<Task> tasks = new ArrayList<>(List.of(
            new Task( "Buy groceries", false),
            new Task( "Finish project report", false),
            new Task( "Go for a run", true),
            new Task( "Read a book", false)
    ));

    public void addTask(Task newTask){
        if(newTask.getId() == null) {
            newTask.setId(newTask.generateId());
        }
        if(newTask.getBody() == null) {
            newTask.setBody("");
        }
        tasks.add(newTask);
    }
    public void addTasks(List<Task> newTasks){
        tasks.addAll(newTasks);
    }

    public Task getTaskById(Long taskId) {
        return tasks.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElse(null);
    }


    public void deleteTask(Long taskId) {
        Task checkTask = getTaskById(taskId);
        if(checkTask != null){
            tasks.removeIf(task -> task.getId().equals(taskId));
        }

    }

    public void updateTask(Long taskId, Task updatedTask) {
        Task task = getTaskById(taskId);

        if(task != null){
            if (updatedTask.getId() != null) {task.setId(updatedTask.getId());}
            if (updatedTask.getTitle() != null) {task.setTitle(updatedTask.getTitle());}
            if (updatedTask.getBody() != null) {task.setBody(updatedTask.getBody());}
            task.setCompleted(updatedTask.isCompleted());
        }
    }
}
