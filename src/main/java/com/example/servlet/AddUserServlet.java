package com.example.servlet;

import com.example.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(request.getParameter("firstName"), request.getParameter("lastName"));
        Warehouse.getInstance().addUser(user);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }
}
