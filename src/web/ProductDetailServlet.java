package web;

import pojo.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 商品详情页servlet
 */
@WebServlet("/productDetail")
public class ProductDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");//获取用户点击的商品的唯一id

        ProductService ps = new ProductServiceImpl();
        Product product = ps.productDetail(id);

        request.setAttribute("product",product);

        request.getRequestDispatcher("detail.jsp").forward(request,response);//
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
