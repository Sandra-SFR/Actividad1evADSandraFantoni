package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.Discount;
import com.sanvalero.telovendo.exception.DiscountNotFoundException;

import java.util.List;

public interface DiscountService {

    List<Discount> findAll();
    Discount findById(long id) throws DiscountNotFoundException;
    Discount addDiscount(Discount discount);
    void deleteDiscount(long id) throws DiscountNotFoundException;
    Discount modifyDiscount(long id, Discount newDiscount) throws DiscountNotFoundException;
}
