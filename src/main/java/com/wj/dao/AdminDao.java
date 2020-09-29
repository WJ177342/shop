package com.wj.dao;

import com.wj.domain.Admin;

public interface AdminDao {
    Admin findAdminByUsernameAndPassword(String usename,String password);
}
