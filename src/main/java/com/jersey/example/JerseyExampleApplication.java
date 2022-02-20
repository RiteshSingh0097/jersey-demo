package com.jersey.example;

import com.jersey.example.dao.EmployeeDAO;
import com.jersey.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JerseyExampleApplication {

    @Autowired
    private EmployeeDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(JerseyExampleApplication.class, args);
    }

    @PostConstruct
    public void initDb() {
        dao.saveAll(Stream
                .of(new Employee(890, "ritesh", "dev"),
                        new Employee(891, "singh", "dev"),
                        new Employee(892, "golu", "hr"),
                        new Employee(893, "harsh", "qa"))
                .collect(Collectors.toList()));
    }

}
