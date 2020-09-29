package com.wj.service;

import com.wj.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> list();
    List<Product> findProductByNameLike(String name);
}
