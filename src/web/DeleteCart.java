package web;

import pojo.Address;
import pojo.User;
import service.AddressService;
import service.CartService;
import service.impl.AddressServiceImpl;
import service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("cid");
        int cid = Integer.parseInt(id);
        CartService cs = new CartServiceImpl();
        int i = cs.deleteCart(cid);

        if (i != 0){
            HttpSession session = request.getSession();
            int uid = (int) session.getAttribute("uid");
            List<Map<String, String>> list = cs.allCart(uid);
            request.setAttribute("cart",list);
            request.getRequestDispatcher("myCart.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
