package hellospringboot.kha2.repository;


import hellospringboot.kha2.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    public TaskRepository() {

        tasks.add(new Task(1, "Learn Java", "Study OOP", "High", 1));
        tasks.add(new Task(2, "Learn Spring", "Study Spring Boot", "High", 2));
        tasks.add(new Task(3, "Database", "Learn MySQL", "Medium", 3));
        tasks.add(new Task(4, "HTML", "Study HTML", "Low", 1));
        tasks.add(new Task(5, "CSS", "Study CSS", "Low", 2));
        tasks.add(new Task(6, "JavaScript", "Study JS", "Medium", 3));
        tasks.add(new Task(7, "REST API", "Learn API", "High", 1));
        tasks.add(new Task(8, "Git", "Learn GitHub", "Medium", 2));
        tasks.add(new Task(9, "Docker", "Learn Docker", "Low", 3));
        tasks.add(new Task(10, "Deploy", "Deploy project", "High", 1));

    }

    public List<Task> findAll() {
        return tasks;
    }

    public void save(Task task) {
        tasks.add(task);
    }
}
