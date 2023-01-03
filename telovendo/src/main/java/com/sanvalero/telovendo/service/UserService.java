package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.User;
import com.sanvalero.telovendo.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<User> findAll();// listar todos los usuarios
    User findById(long id) throws UserNotFoundException; // listar un usuario por id
    User addUser(User user); // crear un usuario
    void deleteUser(long id) throws UserNotFoundException; // borrar un usuario por id
    User modifyUser(long id, User newUser) throws UserNotFoundException; // modificar un usuario por id
}
