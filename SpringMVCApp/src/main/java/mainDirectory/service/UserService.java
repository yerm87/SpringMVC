package mainDirectory.service;

import mainDirectory.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User getUserById(int id);

    void update(User user);

    void delete(int id);
}
