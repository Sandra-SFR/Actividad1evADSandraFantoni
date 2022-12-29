package com.sanvalero.telovendo.repository;

import com.sanvalero.telovendo.domain.BuyLists;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//Crudrepository (clases que acceden a las bbdd) anotacion para que funcione como dao sin escribir sql
public interface BuyListsRepository extends CrudRepository<BuyLists, Long> {
    List<BuyLists> findAll();
    BuyLists findByCode(String code);
}