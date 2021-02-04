package io.agileintelligence.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/* note: @controlleradvice this it does is it breaks exceptions those are controller specific.
    it gives a global handler for exception handlers, every exeption you wire up here, if any controller
    face those, they will come here to get advise to handle those*/
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdddException(ProjectIdException ex, WebRequest request){
        ProjectIdExceptionResponse exceptionResponse=new ProjectIdExceptionResponse(ex.getMessage());
        /* note: we are returning exceptionResponse obj, this one will be passed to with response entity and viewed in front*/
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
