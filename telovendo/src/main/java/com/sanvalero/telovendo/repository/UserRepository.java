package com.sanvalero.telovendo.repository;

import com.sanvalero.telovendo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository//Crudrepository (clases que acceden a las bbdd) anotacion para que funcione como dao sin escribir sql
public interface UserRepository extends CrudRepository<User, Long> {
}