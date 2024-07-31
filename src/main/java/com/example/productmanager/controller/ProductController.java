package com.example.productmanager.controller;

import com.example.productmanager.model.Product;
import com.example.productmanager.service.ProductService;
import com.example.productmanager.service.ProductServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    private static ProductService productService = new ProductServiceServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "edit":
                showFormEdit(req, resp);
                break;
            case "create":
                showFormCreate(req, resp);
                break;
            case"delete":
                showFormDelete(req,resp);
                break;
            default:
                List<Product> products = productService.getAll();
                System.out.println("hello");
                System.out.println(products);
                req.setAttribute("products", products);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
                dispatcher.forward(req, resp);
        }
    }

    private void showFormDelete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("index");
        int index = Integer.parseInt(id);
        Product product = productService.findById(index);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/delete.jsp");
        req.setAttribute("product", product);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("index");
        int index = Integer.parseInt(id);
        Product product = productService.findById(index);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/edit.jsp");
        req.setAttribute("product", product);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "edit":
                editProduct(req, resp);
                break;
            case "create":
                createProduct(req, resp);
                break;
            case"delete":
                    deleteProduct(req, resp);
                    break;
            default:
                break;
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        int index = Integer.parseInt(req.getParameter("index"));
        int id= Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(index);
        productService.delete(id);
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String describe = req.getParameter("describe");
        String producer = req.getParameter("producer");
        Product product = new Product(id, name, price, describe, producer);
        productService.create(product);
        try {
            resp.sendRedirect(req.getContextPath() + "/products");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) {
        int index = Integer.parseInt(req.getParameter("index"));
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String describe = req.getParameter("describe");
        String producer = req.getParameter("producer");
        Product product = new Product(id, name, price, describe, producer);
        productService.update(index, product);
        try {
            resp.sendRedirect(req.getContextPath() + "/products");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
