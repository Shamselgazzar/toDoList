package com.sumerge.todolist.controllers;

import com.sumerge.todolist.models.Task;
import com.sumerge.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/get-tasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }
    @PostMapping(value = "/add-task")
    public void addTasks(@RequestBody Task task){
        taskService.addTask(task);
    }

    @PostMapping(value = "/add-tasks")
    public void addTasks(@RequestBody List<Task> tasks){
        taskService.addTasks(tasks);
    }

    @PutMapping("/update-task/{taskId}")
    public void updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask){
        taskService.updateTask(taskId, updatedTask);
    }

    @DeleteMapping("/delete-task/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }



}
