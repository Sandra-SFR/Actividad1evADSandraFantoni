package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.Discount;
import com.sanvalero.telovendo.exception.DiscountNotFoundException;
import com.sanvalero.telovendo.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<Discount> findAll(){
        return discountRepository.findAll();
    }

    @Override
    public Discount findById(long id) throws DiscountNotFoundException{
        return discountRepository.findById(id)
                .orElseThrow(DiscountNotFoundException::new);
    }

    @Override
    public Discount addDiscount(Discount discount){
        return discountRepository.save(discount);
    }

    @Override
    public void deleteDiscount(long id) throws DiscountNotFoundException{
        Discount discount = discountRepository.findById(id)
                .orElseThrow(DiscountNotFoundException::new);
        discountRepository.delete(discount);
    }

    @Override
    public Discount modifyDiscount(long id, Discount newDiscount) throws DiscountNotFoundException{
        Discount existingDiscount = discountRepository.findById(id)
                .orElseThrow(DiscountNotFoundException::new);
        existingDiscount.setName(newDiscount.getName());
        // Introducir todos los campos que se quieran modificar
        return discountRepository.save(existingDiscount);
    }

}
