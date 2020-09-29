package com.wj.service.impl;

import com.wj.dao.ProductDao;
import com.wj.dao.impl.ProductDaoImpl;
import com.wj.domain.Product;
import com.wj.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> list() {
        return productDao.list();
    }

    @Override
    public List<Product> findProductByNameLike(String name) {
        return productDao.findProductByNameLike(name);
    }
}
