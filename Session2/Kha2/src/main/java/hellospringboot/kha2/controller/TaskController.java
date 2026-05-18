package hellospringboot.kha2.controller;


import hellospringboot.kha2.model.Task;
import hellospringboot.kha2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(
            @RequestParam(required = false) String search
    ) {

        List<Task> tasks = taskService.findAllTasks();

        // tìm kiếm theo title
        if (search != null && !search.isEmpty()) {

            tasks = tasks.stream()
                    .filter(task ->
                            task.getTitle()
                                    .toLowerCase()
                                    .contains(search.toLowerCase()))
                    .collect(Collectors.toList());

        }

        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<?> createTask(
            @RequestBody Task newTask
    ) {

        boolean created = taskService.createTask(newTask);

        // user không tồn tại
        if (!created) {

            return ResponseEntity
                    .badRequest()
                    .body("User does not exist");

        }

        // tạo thành công
        return ResponseEntity
                .status(201)
                .body(newTask);
    }
}
