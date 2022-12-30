package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.BuyLists;
import com.sanvalero.telovendo.repository.BuyListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyListsServiceImpl implements BuyListsService{

    @Autowired//Autoconexion con el repositorio
    private BuyListsRepository buyListsRepository;

    @Override
    public List<BuyLists> findAll(){
        return buyListsRepository.findAll();
    }
    @Override
    public BuyLists findByCode(String code) {
        return buyListsRepository.findByCode(code);
    }
}
