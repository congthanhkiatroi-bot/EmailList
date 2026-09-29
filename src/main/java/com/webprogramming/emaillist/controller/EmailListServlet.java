package com.webprogramming.emaillist.controller;

import com.webprogramming.emaillist.dao.UserDAO;
import com.webprogramming.emaillist.model.User;
import com.webprogramming.emaillist.util.EmailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        User user = new User(
                email,
                firstName,
                lastName
        );

        UserDAO userDAO = new UserDAO();

        boolean success =
                userDAO.insertUser(user);

        if (success) {

            boolean emailSent =
                    EmailUtil.sendConfirmationEmail(
                            user.getEmail(),
                            user.getFirstName(),
                            user.getLastName()
                    );

            request.setAttribute(
                    "user",
                    user
            );

            request.setAttribute(
                    "emailSent",
                    emailSent
            );

            request.getRequestDispatcher("/thanks.jsp")
                    .forward(request, response);

        } else {

            request.setAttribute(
                    "errorMessage",
                    "Unable to register. This email may already be registered."
            );

            request.getRequestDispatcher("/index.jsp")
                    .forward(request, response);
        }
    }
}