package com.wj.dao;

import com.wj.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> list();
    List<Product> findProductByNameLike(String name);
}
