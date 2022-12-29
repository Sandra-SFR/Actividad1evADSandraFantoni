package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.BuyLists;


import java.util.List;

public interface BuyListsService {

    List<BuyLists> findAll();
    BuyLists findByCode(String code);
}
