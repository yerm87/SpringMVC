package mainDirectory.database;

import mainDirectory.entity.User;
import mainDirectory.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDatabaseImplementation implements UserDatabase {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDatabaseImplementation(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO user (name, email, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM user WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user SET name=?, email=?, age=? WHERE id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
