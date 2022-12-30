package com.sanvalero.telovendo.controller;
//metodos para exponer los datos al exterior

import com.sanvalero.telovendo.domain.BuyLists;
import com.sanvalero.telovendo.service.BuyListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyListsController {

    @Autowired
    private BuyListsService buyListsService;

    @GetMapping("/telovendo")//bbdd
    public List<BuyLists> getTelovendo() {
        return buyListsService.findAll();
    }
}
