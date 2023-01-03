package com.sanvalero.telovendo.controller;

import com.sanvalero.telovendo.domain.Discount;
import com.sanvalero.telovendo.exception.DiscountNotFoundException;
import com.sanvalero.telovendo.exception.ErrorMessage;
import com.sanvalero.telovendo.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/telovendo/discount")
    public ResponseEntity<List<Discount>> getTelovendo() {
        return new ResponseEntity<>(discountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/telovendo/discount/{id}")
    public ResponseEntity<Discount> getDiscount(@PathVariable long id) throws DiscountNotFoundException {
        Discount discount = discountService.findById(id);
        return ResponseEntity.ok(discount);
    }

    @PostMapping("/telovendo/discount")
    public ResponseEntity<Discount> addDiscount(@RequestBody Discount discount){
        Discount newDiscount = discountService.addDiscount(discount);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDiscount);
    }

    @DeleteMapping("/telovendo/discount/{id}")
    public ResponseEntity<Void> deleteDiscount(@PathVariable long id) throws DiscountNotFoundException{
        discountService.deleteDiscount(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/telovendo/discount/{id}")
    public ResponseEntity<Discount> modifyDiscount(@PathVariable long id, @RequestBody Discount discount) throws DiscountNotFoundException{
        Discount modifiedDiscount = discountService.modifyDiscount(id, discount);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedDiscount);
    }

    @ExceptionHandler(DiscountNotFoundException.class) // para lanzar errores not found
    public ResponseEntity<ErrorMessage> discountNotFoundException(DiscountNotFoundException dnfe){
        ErrorMessage errorMessage = new ErrorMessage(404, dnfe.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
