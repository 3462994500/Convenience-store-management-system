package com.gec.servlet;

import com.gec.pojo.User;
import com.gec.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/userList","/addUser","/updateUser","/delUser"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        System.out.println(uri);
        if(uri.equals("/userList")){
            UserService userServlet = new UserService();
            List<User> userList = userServlet.queryUser();
            req.setAttribute("userList",userList);
            System.out.println(userList);

            req.getRequestDispatcher("jsp/user/userList.jsp").forward(req,resp);
        }else if (uri.equals("/addUser"))
        {
            String userName = req.getParameter("userName");
            String userPwd = req.getParameter("userPwd");
            String userPhone = req.getParameter("userPhone");
            String userAddress = req.getParameter("userAddress");

            User user = new User(userName, userPwd, userPhone, userAddress);
            UserService userService = new UserService();
            userService.addUser(user);

            resp.sendRedirect("userList");
        } else if (uri.equals("/updateUser")) {
            req.setCharacterEncoding("UTF-8");
            UserService userService = new UserService();
            // 拿到flag 标记
            String flag = req.getParameter("flag");
            if("1".equals(flag)){
                // 点击修改链接 跳转到修改页面
                // 拿到userId
                String userId = req.getParameter("userId");
                // 可以根据id查询用户对象
                User user = userService.queryById(Integer.parseInt(userId));
                // 将user 保存到req中
                req.setAttribute("user",user);
                // 转发修改页面
                req.getRequestDispatcher("jsp/user/UpdateUser.jsp").forward(req,resp);
            }else {
                // 修改页面里面的表单提交的请求
                String id = req.getParameter("id");

                String userName = req.getParameter("userName");
                String password = req.getParameter("userPwd");
                String userPhone = req.getParameter("userPhone");
                String userAddress = req.getParameter("userAddress");

                // 保存到user对象中
                User user = new User(Integer.parseInt(id),userName,password,userPhone,userAddress);
                userService.updateUser(user);
                resp.sendRedirect("userList");
            }
        } else if (uri.equals("/delUser")) {
            String id = req.getParameter("userId");

            UserService userService = new UserService();
            userService.delUser(Integer.parseInt(id));

            resp.sendRedirect("userList");
        }

    }

}
