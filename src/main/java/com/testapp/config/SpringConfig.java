package com.testapp.config;

import com.testapp.dao.UserDao;
import com.testapp.dao.UserDaoImpl;
import com.testapp.service.UserService;
import com.testapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class SpringConfig {

    @Value("${db.url}")
    private String url;
    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }
}
