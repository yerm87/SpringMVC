package mainDirectory.service;

import mainDirectory.database.UserDatabase;
import mainDirectory.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserDatabase userDatabase;

    @Override
    public List<User> findAll() {
        return userDatabase.findAll();
    }

    @Override
    public void save(User user) {
        userDatabase.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userDatabase.getUserById(id);
    }

    @Override
    public void update(User user) {
        userDatabase.update(user);
    }

    @Override
    public void delete(int id) {
        userDatabase.delete(id);
    }
}
