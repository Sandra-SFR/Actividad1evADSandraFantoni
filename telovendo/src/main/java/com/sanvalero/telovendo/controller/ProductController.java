package com.sanvalero.telovendo.controller;

import com.sanvalero.telovendo.domain.Product;
import com.sanvalero.telovendo.exception.ErrorMessage;
import com.sanvalero.telovendo.exception.ProductNotFoundException;
import com.sanvalero.telovendo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired // autoconectamos con el servicio Product
    private ProductService productService;

    @GetMapping("/telovendo/product") // ver listados todos los productos
    public ResponseEntity<List<Product>> getTelovendo(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/telovendo/product/{id}") // ver listado un producto por id
        public ResponseEntity<Product> getProduct(@PathVariable long id) throws ProductNotFoundException{
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/telovendo/product") // crear un producto
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @DeleteMapping("/telovendo/product/{id}") //borrar un porducto por id
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) throws ProductNotFoundException{
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/telovendo/product/{id}") // modificar un producto por id
    public ResponseEntity<Product> modifyProduct(@PathVariable long id, @RequestBody Product product) throws ProductNotFoundException{
        Product modifiedProduct = productService.modifyProduct(id, product);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedProduct);
    }

    @ExceptionHandler(ProductNotFoundException.class) // Lanzar error not found
    public ResponseEntity<ErrorMessage> productNotFoundException(ProductNotFoundException bnfe){
        ErrorMessage errorMessage = new ErrorMessage(404, bnfe.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
