package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.BuyList;
import com.sanvalero.telovendo.exception.BuyListNotFoundException;

import java.util.List;

public interface BuyListService {

    List<BuyList> findAll(); // ver todos
    BuyList findById(long id) throws BuyListNotFoundException; // buscar uno por id
    BuyList addBuyList(BuyList buyList); // dar de alta una lista
    void deleteBuyList(long id) throws BuyListNotFoundException; // borrar lista por id
    BuyList modifyBuyList(long id, BuyList newBuylists) throws BuyListNotFoundException; //modificar por id
}
