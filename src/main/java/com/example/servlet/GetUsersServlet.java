package com.example.servlet;

import com.example.Warehouse;
import com.example.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users") // Alternative to web.xml mapping
public class GetUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Convert Set<User> to List<User>
        List<User> users = new ArrayList<>(Warehouse.getInstance().getUsers());

        request.setAttribute("users", users);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }

}
