package com.gec.servlet;


import com.gec.pojo.User;
import com.gec.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login","/loginOut"})
public class LogInServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();

        if ("/login".equals(uri)) {
            String userPhone = req.getParameter("userPhone");
            String userPwd = req.getParameter("userPwd");

            System.out.println(userPhone + "===" + userPwd);

            UserService userService = new UserService();
            User loginUser = userService.login(userPhone, userPwd);

            if (loginUser != null) {

                session.setAttribute("session_user", loginUser);
                //req.getRequestDispatcher("index.jsp").forward(req,resp);
                resp.sendRedirect("index.jsp");
            } else {
                //req.getRequestDispatcher("login.jsp").forward(req,resp);
                resp.sendRedirect("login.jsp");
            }
        } else if("/loginOut".equals(uri)){
                session.removeAttribute("session_user");
                resp.sendRedirect("login.jsp");
            }
        }
}