package com.example.productmanager.service;

import com.example.productmanager.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductServiceServiceImpl implements ProductService{
    private static List<Product> products;
    static {
        products= new ArrayList<>();
        products.add(new Product(1,"computer", 293300,"Kieu may sam sung", "Sam Sung"));
        products.add(new Product(2,"computer", 293300,"Kieu may sam sung", "Sam Sung"));
        products.add(new Product(3,"computer", 293300,"Kieu may sam sung", "Sam Sung"));
        products.add(new Product(4,"computer", 293300,"Kieu may sam sung", "Sam Sung"));
        products.add(new Product(5,"computer", 293300,"Kieu may sam sung", "Sam Sung"));
    }
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
       products.set(id,product);
    }

    @Override
    public void delete(int id) {
     products.remove(id);
    }
}
