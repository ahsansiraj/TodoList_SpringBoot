package com.app.TodoList.Controller;

import com.app.TodoList.Model.Task;
import com.app.TodoList.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getTasks(Model model) {
        List<Task> taskList = taskService.getAllTask();
        model.addAttribute("tasks", taskList);
        return "tasks";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam String taskName) {
        taskService.createTask(taskName);
        return "redirect:/";
    }

    @PostMapping("/{id}/deleteTask")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/toggle")
    public String toggleTask(@PathVariable int id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
