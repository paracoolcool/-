package Test;
import Util.JDBCUtil;
import dao.CartDao;
import dao.OrderDao;
import dao.impl.CartDaoImpl;
import dao.impl.OrderDaoImpl;
import org.junit.Test;
import pojo.Order;
import pojo.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
public class MyTest {
    @org.junit.Test
    public void test(){
        ProductService ps = new ProductServiceImpl();
        List<Product> list = ps.quickSearch("戴尔");
        System.out.println(list);
        System.out.println(list.size());
    }
}
