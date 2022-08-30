package web;

import service.CartService;
import service.OrderItemService;
import service.impl.CartServiceImpl;
import service.impl.OrderItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/MyOrderItem")
public class MyOrderItem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("uid");//获取当前用户id
        OrderItemService ois = new OrderItemServiceImpl();
        List<Map<String, String>> list = ois.allOrderItem(uid);
        System.out.println(list);
        session.setAttribute("orderItem",list);
        request.getRequestDispatcher("myOrderItem.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
