package com.app.TodoList.Service;

import com.app.TodoList.Model.Task;
import com.app.TodoList.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public void createTask(String taskName) {
        Task task = new Task();
        task.setName(taskName);
        task.setStatus(false); // Initially set as incomplete
        taskRepository.save(task);
    }

    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }

    public void toggleTask(int id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task ID"));
        task.setStatus(!task.isStatus()); // Toggle between complete and incomplete
        taskRepository.save(task);
    }
}
