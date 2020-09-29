package com.wj.dao.impl;

import com.wj.dao.ProductDao;
import com.wj.domain.Product;
import com.wj.tools.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> list() {
        String sql = "select * from easybuy_product";
        ResultSet rs = DBUtil.select(sql);
        List<Product> products = new ArrayList<>();
        try {
            while (rs.next()){
                products.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.shutDB();
        return products;
    }

    @Override
    public List<Product> findProductByNameLike(String name) {
        String sql = "select * from easybuy_product where name like ? ";
        ResultSet rs = DBUtil.select(sql,"%"+name+"%");
        List<Product> products = new ArrayList<>();
        try {
            while (rs.next()){
                products.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.shutDB();
        return products;
    }
}
