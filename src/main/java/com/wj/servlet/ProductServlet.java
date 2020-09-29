package com.wj.servlet;

import com.google.gson.Gson;
import com.wj.domain.Product;
import com.wj.service.ProductService;
import com.wj.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String op = req.getParameter("op");
        if ("like".equals(op)){
            this.like(req,resp);
        }
    }

    private void like(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println(name);
        List<Product> products = productService.findProductByNameLike(name);
        PrintWriter out = resp.getWriter();
        if (products!=null){
            Gson gson = new Gson();
            String json = gson.toJson(products);
            out.write(json);
        }else {
            out.write("null");
        }
        out.flush();
    }
}
