package com.jersey.example.mapper;

import com.jersey.example.dto.ErrorMessage;
import com.jersey.example.exception.ServiceException;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.io.PrintWriter;
import java.io.StringWriter;


public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {
    @Override
    public Response toResponse(ServiceException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(exception.getStatusCode());
        errorMessage.setMessage(exception.getMessage());
        StringWriter writer = new StringWriter();
        exception.printStackTrace(new PrintWriter(writer));
        return Response
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
