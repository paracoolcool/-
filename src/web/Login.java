package web;

import pojo.Address;
import pojo.User;
import service.AddressService;
import service.UserService;
import service.impl.AddressServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //接受浏览器提交过来的数据
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        UserService userService = new UserServiceImpl();
        User user = userService.login(username,password);
        AddressService addressService = new AddressServiceImpl();
        int uid = user.getUid();

        String loginInfo = "";//反馈信息
        if(user == null){
            //将登录失败的信息放到request域中供前端获取
            loginInfo="对不起，用户名或密码错误，请检查！";
            request.setAttribute("loginInfo","对不起，用户名或密码错误，请检查！");
            return;
        }
        //登录成功将用户信息保存到session域中(只要浏览器不关闭，同一个项目中都可以共享数据)
        //如果user不为空，则登录成功并且跳转到登录成功的页面
        HttpSession session =request.getSession();
        session.setAttribute("user",user);
        session.setAttribute("uid",uid);
        User user1 = (User) session.getAttribute("user");
        int id = user1.getUid();

        List<Address> addByuid = addressService.findAddByuid(id);

        session.setAttribute("list",addByuid);
        //创建cookie
        Cookie cookie  =  new Cookie("phone",username);
        cookie.setMaxAge(24*3600);//cookie生命周期
        response.addCookie(cookie);//添加cookie
        
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
