package web;

import Util.Md5Util;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取前端输入的电话和密码
        String phone=request.getParameter("phone");
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String password_sure=request.getParameter("password_sure");
        
        String registerMsg = "请确认密码";
        if (password.equals(password_sure)){
            String s = Md5Util.string2MD5(password);//md5加密
            System.out.println(s);
            UserService userService = new UserServiceImpl();
            boolean register = userService.register(phone, name,s);
            if (register){

                registerMsg = "注册成功,为你返回登录";
                request.setAttribute("registerMsg",registerMsg);
                request.getRequestDispatcher("login.jsp").forward(request,response);
                return;
            }else {
                registerMsg = "该号码已注册,请重新输入";
                request.setAttribute("registerMsg",registerMsg);
            }
        }
        request.setAttribute("registerMsg",registerMsg);
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
