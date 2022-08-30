package web;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * 头像上传功能实现
 */
@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码
        request.setCharacterEncoding("utf-8");

        String baseDir = "F://WebCouserDesign//web//images";
        File f = new File(baseDir);
        if(!f.exists()){
            f.mkdirs();
        }

        //获取一个文件单元
        Part part = request.getPart("myfile");
        String type = part.getContentType();
        long size = part.getSize();
        String fname = part.getSubmittedFileName();

        System.out.println("文件名称:"+fname);
        System.out.println("文件类型:"+type);
        System.out.println("文件大小:"+size);
        //存储到服务器
        part.write(baseDir + File.separator + fname);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getUid();
        //将文件名称存储到request范围
        request.setAttribute("fname", fname);
        UserService userService = new UserServiceImpl();
        userService.changeImg(fname,id);
        //更新session
        User user1 = userService.uMsg(id);
        session.setAttribute("user",user1);
        //请求转发到下一个页面中
        request.getRequestDispatcher("myself.jsp").forward(request, response);


    }
}