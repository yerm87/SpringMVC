package mainDirectory.config;

import mainDirectory.database.UserDatabase;
import mainDirectory.database.UserDatabaseImplementation;
import mainDirectory.entity.User;
import mainDirectory.service.UserService;
import mainDirectory.service.UserServiceImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {"mainDirectory.service", "mainDirectory.database"})
public class ConfigClass {
    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDriverManagerDataSource());
    }

    @Bean
    public DataSource getDriverManagerDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/webapp");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
