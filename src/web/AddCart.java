package web;

import pojo.User;
import service.CartService;
import service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int pid= Integer.parseInt(request.getParameter("id"));
        long price= Long.parseLong(request.getParameter("price"));
        HttpSession session =request.getSession();
        User user1 = (User) session.getAttribute("user");
        int uid = user1.getUid();
        CartService cs = new CartServiceImpl();
        int i = cs.addCart(uid, pid, price, 1);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
