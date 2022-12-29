package com.sanvalero.telovendo.repository;

import com.sanvalero.telovendo.domain.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository//Crudrepository (clases que acceden a las bbdd) anotacion para que funcione como dao sin escribir sql
public interface CommentsRepository extends CrudRepository<Comments, Long> {
}
