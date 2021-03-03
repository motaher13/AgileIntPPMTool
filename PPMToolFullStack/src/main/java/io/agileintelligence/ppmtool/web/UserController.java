package io.agileintelligence.ppmtool.web;

import io.agileintelligence.ppmtool.domain.User;
import io.agileintelligence.ppmtool.service.MapValidationErrorService;
import io.agileintelligence.ppmtool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult bindingResult){

        ResponseEntity<?> errorMap=mapValidationErrorService.MapValidationService(bindingResult);
        if(errorMap!=null) return errorMap;

        User newUser=userService.saveUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
}
