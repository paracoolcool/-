package web;

import pojo.Address;
import pojo.User;
import service.AddressService;
import service.impl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/addAddress")
public class AddAddress extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*获取前端传来的数据*/
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String sheng = request.getParameter("sheng");
        String city = request.getParameter("city");
        String add_msg = request.getParameter("add_msg");
        String type = request.getParameter("type");
        String area = request.getParameter("area");

        /*获取session域中登录用户的id*/
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int uid = user.getUid();

        AddressService ads = new AddressServiceImpl();
        int i = ads.addAddress(name, phone, sheng, city, add_msg, type,area, uid);
        List<Address> addByuid = ads.findAddByuid(uid);
        //更新session中收货地址信息
        session.setAttribute("list",addByuid);
        System.out.println("session:"+session.getAttribute("list"));
        if (i != 0){
            request.getRequestDispatcher("myself.jsp").forward(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
