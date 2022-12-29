package com.sanvalero.telovendo.repository;

import com.sanvalero.telovendo.domain.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository//Crudrepository (clases que acceden a las bbdd) anotacion para que funcione como dao sin escribir sql
public interface UsersRepository extends CrudRepository<Users, Long> {
}
