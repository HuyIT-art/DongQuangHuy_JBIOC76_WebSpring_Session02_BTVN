package hellospringboot.kha2.repository;


import hellospringboot.kha2.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {

        users.add(new User(1, "Huy", "huy@gmail.com", "Admin"));
        users.add(new User(2, "Nam", "nam@gmail.com", "User"));
        users.add(new User(3, "Linh", "linh@gmail.com", "User"));

    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {

        for (User user : users) {

            if (user.getId() == id) {
                return user;
            }

        }

        return null;
    }
}
