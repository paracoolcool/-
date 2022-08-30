package web;

import pojo.Cart;
import pojo.Order;
import pojo.Product;
import service.CartService;
import service.OrderItemService;
import service.OrderService;
import service.ProductService;
import service.impl.CartServiceImpl;
import service.impl.OrderItemServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cs = new CartServiceImpl();
        OrderService os = new OrderServiceImpl();
        ProductService ps = new ProductServiceImpl();
        OrderItemService ois = new OrderItemServiceImpl();

        int aid = Integer.parseInt(request.getParameter("aid"));
        String[] cids = request.getParameterValues("cids");//获取数组
        int[] a = new int[cids.length];
        long sum = Long.parseLong(request.getParameter("sum"));
        HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("uid");
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());//获取当前时间

        int i = os.addOrder(uid, aid, sum, timeStamp);
        String strn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeStamp);//转换为string类型
        Order order = os.getOrderBytime(strn);
        int oid = order.getOid();
       


        if (i!=0){
            for (int m=0;m<cids.length;m++){
                a[m] = Integer.parseInt(cids[m]);
                int pid = cs.getPid(a[m]);

                //获取下单商品的信息
                Product product = ps.productDetail(String.valueOf(pid));

                String title = product.getTitle();
                String image = product.getImage();
                long price = product.getPrice();
                int i1 = ois.addAOItem(oid, pid, title, image, price, 1);


                cs.deleteCart(a[m]);//对选中下单的商品从购物车中删除
            }
            request.getRequestDispatcher("/MyCart").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
