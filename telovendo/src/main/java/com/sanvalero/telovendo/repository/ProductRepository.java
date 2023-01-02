package com.sanvalero.telovendo.repository;

import com.sanvalero.telovendo.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository//Crudrepository (clases que acceden a las bbdd) anotacion para que funcione como dao sin escribir sql
public interface ProductRepository extends CrudRepository<Product, Long> {



}