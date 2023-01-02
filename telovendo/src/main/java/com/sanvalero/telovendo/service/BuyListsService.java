package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.BuyLists;
import com.sanvalero.telovendo.exception.BuyListsNotFoundException;


import java.util.List;

public interface BuyListsService {

    List<BuyLists> findAll(); // ver todos
    BuyLists findById(long id) throws BuyListsNotFoundException; // buscar uno por codigo

    void addBuyLists(BuyLists buyLists); // dra de alta una lista
}
