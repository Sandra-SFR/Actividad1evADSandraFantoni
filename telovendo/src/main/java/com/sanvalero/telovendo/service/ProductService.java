package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.Product;
import com.sanvalero.telovendo.exception.ProductNotFoundException;
import java.util.List;

public interface ProductService {

    List<Product> findAll();// listar todos los productos
    Product findById(long id) throws ProductNotFoundException; // listar un producto por id
    Product addProduct(Product product); // crear un producto
    void deleteProduct(long id) throws ProductNotFoundException; // borrar un producto por id
    Product modifyProduct(long id, Product newProduct) throws ProductNotFoundException; // modificar un producto por id
}
