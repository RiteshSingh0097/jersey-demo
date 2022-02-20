package com.jersey.example.config;

import com.jersey.example.controller.EmployeeController;
import com.jersey.example.mapper.ServiceExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(EmployeeController.class);
        register(ServiceExceptionMapper.class);
    }
}
