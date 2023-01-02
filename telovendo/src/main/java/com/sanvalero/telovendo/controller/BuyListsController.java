package com.sanvalero.telovendo.controller;
//metodos para exponer los datos al exterior

import com.sanvalero.telovendo.domain.BuyLists;
import com.sanvalero.telovendo.exception.BuyListsNotFoundException;
import com.sanvalero.telovendo.exception.ErrorMessage;
import com.sanvalero.telovendo.service.BuyListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuyListsController {

    @Autowired
    private BuyListsService buyListsService;

    @GetMapping("/telovendo")// ver todos
    public ResponseEntity<List<BuyLists>> getTelovendo() {
        //return ResponseEntity.ok(buyListsService.findAll());
        return new ResponseEntity<>(buyListsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("telovendo/{id}") // ver uno por id
    public ResponseEntity<BuyLists>  getBuyLists(@PathVariable long id) throws BuyListsNotFoundException {
        BuyLists buyLists = buyListsService.findById(id);
        return ResponseEntity.ok(buyLists);
    }

    @PostMapping("/telovendo") // añadir uno
    public void addBuyLists(@RequestBody BuyLists buyLists) {
        buyListsService.addBuyLists(buyLists);
    }

    @DeleteMapping("/telovendo/{id}")  // borrar uno por id
    public void deleteBuyLists(@PathVariable long id){

    }

    @PutMapping("/telovendo/{id}") // modificar uno por id
    public void modifyBuyLists(@PathVariable long id, @RequestBody BuyLists buyLists){

    }

    @ExceptionHandler(BuyListsNotFoundException.class)
    public ResponseEntity<ErrorMessage> buyListsNotFoundException(BuyListsNotFoundException bnfe){
        ErrorMessage errorMessage = new ErrorMessage(404, bnfe.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
