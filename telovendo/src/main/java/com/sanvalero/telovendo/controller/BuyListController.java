package com.sanvalero.telovendo.controller;
//metodos para exponer los datos al exterior

import com.sanvalero.telovendo.domain.BuyList;
import com.sanvalero.telovendo.exception.BuyListNotFoundException;
import com.sanvalero.telovendo.exception.ErrorMessage;
import com.sanvalero.telovendo.service.BuyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuyListController {

    @Autowired
    private BuyListService buyListService;

    @GetMapping("/telovendo")// ver todos
    public ResponseEntity<List<BuyList>> getTelovendo() {
        //return ResponseEntity.ok(buyListsService.findAll());
        return new ResponseEntity<>(buyListService.findAll(), HttpStatus.OK);
    }

    @GetMapping("telovendo/{id}") // ver uno por id
    public ResponseEntity<BuyList>  getBuyLists(@PathVariable long id) throws BuyListNotFoundException {
        BuyList buyList = buyListService.findById(id);
        return ResponseEntity.ok(buyList);
    }

    @PostMapping("/telovendo") // añadir uno
    public ResponseEntity<BuyList> addBuyLists(@RequestBody BuyList buyList) {
        BuyList newBuyList = buyListService.addBuyList(buyList);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBuyList);
    }

    @DeleteMapping("/telovendo/{id}")  // borrar uno por id
    public ResponseEntity<Void> deleteBuyLists(@PathVariable long id) throws BuyListNotFoundException {
        buyListService.deleteBuyList(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/telovendo/{id}") // modificar uno por id
    public ResponseEntity<BuyList> modifyBuyLists(@PathVariable long id, @RequestBody BuyList buyList) throws BuyListNotFoundException {
        BuyList modifiedBuyList = buyListService.modifyBuyList(id, buyList);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedBuyList);
    }

    @ExceptionHandler(BuyListNotFoundException.class) // para lanzar errores not found
    public ResponseEntity<ErrorMessage> buyListsNotFoundException(BuyListNotFoundException bnfe){
        ErrorMessage errorMessage = new ErrorMessage(404, bnfe.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    //    @ExceptionHandler(Exception.class) // para lanzar errores no recogidos
    //    public ResponseEntity<ErrorMessage> handleException(Exception e) {
    //        ErrorMessage errorMessage = new ErrorMessage(500, "Internal Server Error");
    //        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    //    }

}
