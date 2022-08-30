package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
/*
* 退出当前登录并清除session和cookie信息
* */

@WebServlet("/Logout")
public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将session中的用户信息清空
        //思路：再session中创建一个同名的对象，设置有效时间为0
        HttpSession session =request.getSession();
        session.setAttribute("user",null);
        session.setMaxInactiveInterval(0);//有效时间,默认是30min
        //清除cookie中的“phone”
        Cookie newCookie=new Cookie("phone",null); //假如要删除名称为username的Cookie

        newCookie.setMaxAge(0); //立即删除型
        newCookie.setDomain("localhost");
        newCookie.setPath("/WebCouserDesign"); //项目所有目录均有效，这句很关键，否则不敢保证删除

        response.addCookie(newCookie); //重新写入，将覆盖之前的
        //跳转到登录界面
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
