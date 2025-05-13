package com.gec.servlet;

import com.gec.pojo.Goods;
import com.gec.pojo.Vendor;
import com.gec.service.GoodService;
import com.gec.service.VendorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/goodList","/addGood","/updateGood","/delGood"})
public class GoodServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        if("/goodList".equals(uri)){
            GoodService goodServlet = new GoodService();
            List<Goods> goodsList = goodServlet.queryGood();
            req.setAttribute("goodList",goodsList);
            System.out.println(goodsList);

            req.getRequestDispatcher("jsp/good/goodList.jsp").forward(req,resp);
        }else if ("/addGood".equals(uri)){
            String goodNum = req.getParameter("goodNum");
            String goodName = req.getParameter("goodName");
            String price = req.getParameter("price");
            String unit = req.getParameter("unit");
            String vPrice = req.getParameter("vPrice");

            String flag = req.getParameter("flag");
            if("1".equals(flag)) {
                VendorService vendorService = new VendorService();
                List<Vendor> vendorList = vendorService.queryVendor();
                req.setAttribute("vendorList", vendorList);
                req.getRequestDispatcher("jsp/good/addGood.jsp").forward(req, resp);
            }else{
                String vendorId = req.getParameter("vendorId");
                System.out.println("----"+vendorId);
                Goods goods = new Goods(goodNum ,goodName,Integer.parseInt(price),unit,Integer.parseInt(vPrice),Integer.parseInt(vendorId));
                GoodService goodService = new GoodService();
                goodService.addGood(goods);
            }
            resp.sendRedirect("goodList");
        } else if (uri.equals("/updateGood")) {
            req.setCharacterEncoding("UTF-8");
            GoodService goodService = new GoodService();
            // 拿到flag 标记
            String flag = req.getParameter("flag");
            if("1".equals(flag)){
                // 点击修改链接 跳转到修改页面
                // 拿到goodId
                String goodId = req.getParameter("goodId");

                // 可以根据id查询用户对象
                Goods goods = goodService.queryById(Integer.parseInt(goodId));

                // 将good 保存到req中
                req.setAttribute("good",goods);

                // 转发修改页面
     //           req.getRequestDispatcher("jsp/good/UpdateGood.jsp").forward(req,resp);

                VendorService vendorService = new VendorService();
                List<Vendor> vendorList = vendorService.queryVendor();
                req.setAttribute("vendorList", vendorList);
                req.getRequestDispatcher("jsp/good/UpdateGood.jsp").forward(req, resp);
            }else {
                // 修改页面里面的表单提交的请求
                String id = req.getParameter("id");

                String goodNum = req.getParameter("goodNum");
                String goodName = req.getParameter("goodName");
                String price = req.getParameter("price");
                String unit = req.getParameter("unit");
                String vPrice = req.getParameter("vPrice");
                String vendorId = req.getParameter("vendorId");
                System.out.println("----"+vendorId);
                    // 保存到goods对象中
                    Goods goods = new Goods(Integer.parseInt(id),goodNum ,goodName,Integer.parseInt(price),unit,Integer.parseInt(vPrice),Integer.parseInt(vendorId));
                    goodService.updateGood(goods);
                // 重定向，让浏览器重新访问goodlist
                resp.sendRedirect("goodList");
            }
        } else if (uri.equals("/delGood")) {
            String id = req.getParameter("goodId");

            GoodService goodService = new GoodService();
            goodService.delGood(Integer.parseInt(id));

            resp.sendRedirect("goodList");
        }
    }
}
