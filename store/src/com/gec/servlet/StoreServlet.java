package com.gec.servlet;

import com.gec.pojo.Store;
import com.gec.service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/storeList")
@WebServlet(urlPatterns = {"/storeList","/addStore","/updateStore","/delStore"})
public class StoreServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        System.out.println(uri);
        if(uri.equals("/storeList")){
            StoreService storeServlet = new StoreService();
            List<Store> storeList = storeServlet.queryStore();
            req.setAttribute("storeList",storeList);
            System.out.println(storeList);

            req.getRequestDispatcher("jsp/store/storeList.jsp").forward(req,resp);
        }else if (uri.equals("/addStore"))
        {
            String storeNum = req.getParameter("storeNum");
            String storeName = req.getParameter("storeName");
            String storeAddress = req.getParameter("storeAddress");

            Store store = new Store(storeNum,storeName,storeAddress);
            StoreService storeService = new StoreService();
            storeService.addStore(store);

            resp.sendRedirect("storeList");
        } else if (uri.equals("/updateStore")) {
            req.setCharacterEncoding("UTF-8");
            StoreService storeService = new StoreService();
            // 拿到flag 标记
            String flag = req.getParameter("flag");
            if("1".equals(flag)){
                // 点击修改链接 跳转到修改页面
                // 拿到storeId
                String storeId = req.getParameter("storeId");

                // 可以根据id查询用户对象
                Store store = storeService.queryById(Integer.parseInt(storeId));

                // 将store 保存到req中
                req.setAttribute("store",store);

                // 转发修改页面
                req.getRequestDispatcher("jsp/store/UpdateStore.jsp").forward(req,resp);
            }else {
                // 修改页面里面的表单提交的请求
                String id = req.getParameter("id");

                String storeNum = req.getParameter("storeNum");
                String storeName = req.getParameter("storeName");
                String storeAddress = req.getParameter("storeAddress");

                // 保存到store对象中
                Store store = new Store(Integer.parseInt(id),storeNum,storeName,storeAddress);
                storeService.updateStore(store);

                //
                // req.getRequestDispatcher("storeList").forward(req,resp);
                // 重定向，让浏览器重新访问storelist
                resp.sendRedirect("storeList");
            }
        } else if (uri.equals("/delStore")) {
            String id = req.getParameter("storeId");

            StoreService storeService = new StoreService();
            storeService.delStore(Integer.parseInt(id));

            resp.sendRedirect("storeList");
        }

    }

}
