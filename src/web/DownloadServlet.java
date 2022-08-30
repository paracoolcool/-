package web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/Download")
@MultipartConfig
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filename = request.getParameter("filename");
        response.setContentType(this.getServletContext().getMimeType(filename));
        response.setHeader("Content-Disposition", "attachment;filename="+filename);
        String realPath = this.getServletContext().getRealPath("/resouce/"+filename);
        InputStream in = new FileInputStream(realPath);
        ServletOutputStream out = response.getOutputStream();
        int len=0;
        byte[] buffer =new byte[1024];
        while((len=in.read(buffer))>0) {
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }
}
