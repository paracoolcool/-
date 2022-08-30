package web;

import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/Purchaser")
public class Purchaser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService os = new OrderServiceImpl();

        int aid = Integer.parseInt(request.getParameter("aid"));
        long sum = Long.parseLong(request.getParameter("sum"));
        HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("uid");
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());//获取当前时间
        int i = os.addOrder(uid, aid, sum, timeStamp);
        request.getRequestDispatcher("detail.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
