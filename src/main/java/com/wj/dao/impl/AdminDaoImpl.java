package com.wj.dao.impl;

import com.wj.dao.AdminDao;
import com.wj.domain.Admin;
import com.wj.tools.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin findAdminByUsernameAndPassword(String usename, String password) {
        String sql = "select * from admin where username = ? and password = ?";
        ResultSet rs = DBUtil.select(sql, usename, password);
        Admin admin = null;
        try {
            if (rs.next()){
                admin = new Admin(rs.getString(1),rs.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.shutDB();
        return admin;
    }
}
