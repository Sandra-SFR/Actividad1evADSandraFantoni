package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.Product;
import com.sanvalero.telovendo.exception.ProductNotFoundException;
import com.sanvalero.telovendo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) throws ProductNotFoundException{
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        productRepository.delete(product);
    }

    @Override
    public Product modifyProduct(long id, Product newProduct) throws ProductNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        existingProduct.setName(newProduct.getName());
        // Introducir todos los campos que se quieran modificar
        return productRepository.save(existingProduct);
    }
}
