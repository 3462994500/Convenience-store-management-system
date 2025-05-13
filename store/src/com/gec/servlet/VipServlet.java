package com.gec.servlet;

import com.gec.pojo.Vip;
import com.gec.service.VipService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/vipList")
@WebServlet(urlPatterns = {"/vipList","/addVip","/updateVip","/delVip"})
public class VipServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        System.out.println(uri);
        if(uri.equals("/vipList")){
            VipService vipServlet = new VipService();
            List<Vip> vipList = vipServlet.queryVip();
            req.setAttribute("vipList",vipList);
            System.out.println(vipList);

            req.getRequestDispatcher("jsp/vip/vipList.jsp").forward(req,resp);
        }else if (uri.equals("/addVip"))
        {
            String vipName = req.getParameter("vipName");
            String vipPhone = req.getParameter("vipPhone");
            String vipAddress = req.getParameter("vipAddress");

            Vip vip = new Vip(vipName, vipPhone, vipAddress);
            VipService vipService = new VipService();
            vipService.addVip(vip);

            resp.sendRedirect("vipList");
        } else if (uri.equals("/updateVip")) {
            req.setCharacterEncoding("UTF-8");
            VipService vipService = new VipService();
            // 拿到flag 标记
            String flag = req.getParameter("flag");
            if("1".equals(flag)){
                // 点击修改链接 跳转到修改页面
                // 拿到vipId
                String vipId = req.getParameter("vipId");

                // 可以根据id查询用户对象
                Vip vip = vipService.queryById(Integer.parseInt(vipId));

                // 将vip 保存到req中
                req.setAttribute("vip",vip);

                // 转发修改页面
                req.getRequestDispatcher("jsp/vip/UpdateVip.jsp").forward(req,resp);
            }else {
                // 修改页面里面的表单提交的请求
                String id = req.getParameter("id");

                String vipName = req.getParameter("vipName");
                String vipPhone = req.getParameter("vipPhone");
                String vipAddress = req.getParameter("vipAddress");

                // 保存到vip对象中
                Vip vip = new Vip(Integer.parseInt(id),vipName,vipPhone,vipAddress);
                vipService.updateVip(vip);

                //
                // req.getRequestDispatcher("vipList").forward(req,resp);
                // 重定向，让浏览器重新访问viplist
                resp.sendRedirect("vipList");
            }
        } else if (uri.equals("/delVip")) {
            String id = req.getParameter("vipId");

            VipService vipService = new VipService();
            vipService.delVip(Integer.parseInt(id));

            resp.sendRedirect("vipList");
        }

    }

}
