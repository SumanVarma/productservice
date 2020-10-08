package com.test.productservice.controller;

import com.test.productservice.entity.Product;
import com.test.productservice.exception.ResourceNotFoundException;
import com.test.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        product.setActive(true);
        return productRepository.save(product);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> productById(@PathVariable("id") long id) throws ResourceNotFoundException {
        HttpStatus httpStatus = HttpStatus.OK;
        Product product = getProduct(id);

        if (ObjectUtils.isEmpty(product)) {
            httpStatus = HttpStatus.NOT_FOUND;
            throw new ResourceNotFoundException("Product not found");
        }
        return new ResponseEntity<>(product, httpStatus);

    }

    private Product getProduct(@NotNull long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,
                                                 @Valid @RequestBody Product product) throws ResourceNotFoundException {
        HttpStatus httpStatus = HttpStatus.OK;
        Product actualProduct = getProduct(id);
        System.out.printf("product ", actualProduct);
        if (ObjectUtils.isEmpty(product)) {
            httpStatus = HttpStatus.NOT_FOUND;
            throw new ResourceNotFoundException("Product not found");
        } else {
            // BeanUtils.copyProperties(product, actualProduct);
            product.setId(id);
            productRepository.save(product);
        }

        return new ResponseEntity<>(product, httpStatus);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) throws ResourceNotFoundException {
        HttpStatus httpStatus = HttpStatus.ACCEPTED;
        Product product = getProduct(id);

        if (ObjectUtils.isEmpty(product)) {
            httpStatus = HttpStatus.NOT_FOUND;
            throw new ResourceNotFoundException("Product not found");
        } else {

            productRepository.deleteById(id);
        }
        return new ResponseEntity<>(httpStatus);
    }
}