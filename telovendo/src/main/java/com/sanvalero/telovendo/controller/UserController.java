package com.sanvalero.telovendo.controller;

import com.sanvalero.telovendo.domain.User;
import com.sanvalero.telovendo.exception.ErrorMessage;
import com.sanvalero.telovendo.exception.UserNotFoundException;
import com.sanvalero.telovendo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/telovendo/user")// ver todos
    public ResponseEntity<List<User>> getTelovendo() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("telovendo/user/{id}") // ver uno por id
    public ResponseEntity<User> getUser(@PathVariable long id) throws UserNotFoundException {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/telovendo/user") // añadir uno
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @DeleteMapping("/telovendo/user/{id}")  // borrar uno por id
    public ResponseEntity<Void> deleteUser(@PathVariable long id) throws UserNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/telovendo/user/{id}") // modificar uno por id
    public ResponseEntity<User> modifyUser(@PathVariable long id, @RequestBody User user) throws UserNotFoundException {
        User modifiedUser = userService.modifyUser(id, user);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedUser);
    }

    @ExceptionHandler(UserNotFoundException.class) // para lanzar errores not found
    public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException unfe){
        ErrorMessage errorMessage = new ErrorMessage(404, unfe.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
