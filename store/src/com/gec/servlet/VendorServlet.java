package com.gec.servlet;

import com.gec.pojo.Vendor;
import com.gec.service.VendorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/vendorList")
@WebServlet(urlPatterns = {"/vendorList","/addVendor","/updateVendor","/delVendor"})
public class VendorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        System.out.println(uri);
        if(uri.equals("/vendorList")){
            VendorService vendorServlet = new VendorService();
            List<Vendor> vendorList = vendorServlet.queryVendor();
            req.setAttribute("vendorList",vendorList);
            System.out.println(vendorList);

            req.getRequestDispatcher("jsp/vendor/vendorList.jsp").forward(req,resp);
        }else if (uri.equals("/addVendor"))
        {
            String vendorNum = req.getParameter("vendorNum");
            String vendorName = req.getParameter("vendorName");

            Vendor vendor = new Vendor(vendorNum, vendorName);
            VendorService vendorService = new VendorService();
            vendorService.addVendor(vendor);

            resp.sendRedirect("vendorList");
        } else if (uri.equals("/updateVendor")) {
            req.setCharacterEncoding("UTF-8");
            VendorService vendorService = new VendorService();
            // 拿到flag 标记
            String flag = req.getParameter("flag");
            if("1".equals(flag)){
                // 点击修改链接 跳转到修改页面
                // 拿到vendorId
                String vendorId = req.getParameter("vendorId");

                // 可以根据id查询用户对象
                Vendor vendor = vendorService.queryById(Integer.parseInt(vendorId));

                // 将vendor 保存到req中
                req.setAttribute("vendor",vendor);

                // 转发修改页面
                req.getRequestDispatcher("jsp/vendor/UpdateVendor.jsp").forward(req,resp);
            }else {
                // 修改页面里面的表单提交的请求
                String id = req.getParameter("id");

                String vendorNum = req.getParameter("vendorNum");
                String vendorName = req.getParameter("vendorName");

                // 保存到vendor对象中
                Vendor vendor = new Vendor(Integer.parseInt(id),vendorNum, vendorName);
                vendorService.updateVendor(vendor);

                //
                // req.getRequestDispatcher("vendorList").forward(req,resp);
                // 重定向，让浏览器重新访问vendorlist
                resp.sendRedirect("vendorList");
            }
        } else if (uri.equals("/delVendor")) {
            String id = req.getParameter("vendorId");

            VendorService vendorService = new VendorService();
            vendorService.delVendor(Integer.parseInt(id));

            resp.sendRedirect("vendorList");
        }

    }

}
