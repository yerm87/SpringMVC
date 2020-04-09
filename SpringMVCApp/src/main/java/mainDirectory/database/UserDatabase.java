package mainDirectory.database;

import mainDirectory.entity.User;

import java.util.List;

public interface UserDatabase {
    List<User> findAll();

    void save(User user);

    User getUserById(int id);

    void update(User user);

    void delete(int id);
}
