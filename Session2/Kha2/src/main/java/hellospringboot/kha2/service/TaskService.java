package hellospringboot.kha2.service;


import hellospringboot.kha2.model.Task;
import hellospringboot.kha2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    @Autowired
    public TaskService(TaskRepository taskRepository,
                       UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public boolean createTask(Task newTask) {

        User user = userService.findUserById(newTask.getAssignedTo());

        // user không tồn tại
        if (user == null) {
            return false;
        }

        // lưu task
        taskRepository.save(newTask);

        return true;
    }
}
