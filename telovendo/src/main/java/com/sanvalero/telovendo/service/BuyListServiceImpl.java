package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.BuyList;
import com.sanvalero.telovendo.exception.BuyListNotFoundException;
import com.sanvalero.telovendo.repository.BuyListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyListServiceImpl implements BuyListService {

    @Autowired//Autoconexion con el repositorio
    private BuyListRepository buyListRepository;

    @Override
    public List<BuyList> findAll(){
        return buyListRepository.findAll();
    }

    @Override
    public BuyList findById(long id) throws BuyListNotFoundException {
        return buyListRepository.findById(id)
                .orElseThrow(BuyListNotFoundException::new);
    }

    @Override
    public BuyList addBuyList(BuyList buyList){
       return buyListRepository.save(buyList);
    }

    @Override
    public void deleteBuyList(long id) throws BuyListNotFoundException {
        BuyList buyList = buyListRepository.findById(id)
                        .orElseThrow(BuyListNotFoundException::new);
        buyListRepository.delete(buyList);
    }

    @Override
    public BuyList modifyBuyList(long id, BuyList newBuyList) throws BuyListNotFoundException {
        BuyList existingBuyList = buyListRepository.findById(id)
                .orElseThrow(BuyListNotFoundException::new);
        existingBuyList.setName(newBuyList.getName());
        // Introducir todos los campos que se quieran modificar
        return buyListRepository.save(existingBuyList);
    }
}
