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

/***
 * 删除一条收货地址
 */
@WebServlet("/DeleteAddr")
public class DeleteAddr extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("aid");//获取要删除的收货地址的id
        int aid = Integer.parseInt(id);
        System.out.println(aid);
        AddressService as = new AddressServiceImpl();
        int i = as.deleteAddress(aid);
        if (i != 0){
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int uid = user.getUid();
            List<Address> list = as.findAddByuid(uid);
            session.setAttribute("list",list);//更新收货地址列表session信息
            request.getRequestDispatcher("myself.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
