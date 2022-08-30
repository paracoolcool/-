package dao.impl;

import Util.JDBCUtil;
import dao.OrderItemDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderItemDaoImpl implements OrderItemDao {
    String sql="";
    /***
     * 添加一条订单项
     * @param oid 订单项对应订单号
     * @param pid   商品id
     * @param title 商品标题
     * @param image 商品图片
     * @param price 商品价格
     * @param num   商品数量
     * @return 添加结果i
     */
    @Override
    public int addAOItem(int oid, int pid, String title, String image, long price, int num) {
        sql = "INSERT INTO t_order_item (oid,pid,title,image,price,num) VALUES (?,?,?,?,?,?)";
        int i = JDBCUtil.executeUpdate(sql, oid, pid, title, image, price, num);
        return i;
    }

    @Override
    public List<Map<String, String>> allOrderItem(int uid) {
        sql = "SELECT a.oid,a.title,a.image,a.price,a.num,b.total_price,b.order_time FROM `t_order_item` a,t_order b WHERE a.oid=b.oid AND uid=?";
        ResultSet resultSet = JDBCUtil.executeQuery(sql, uid);
        List<Map<String,String>> list=new ArrayList<Map<String, String>>();
        try {
            while (resultSet.next()){

                Map<String,String> map = new HashMap<>();
                map.put("oid",resultSet.getString("oid"));
                map.put("title",resultSet.getString("title"));
                map.put("price",resultSet.getString("price"));
                map.put("num",resultSet.getString("num"));
                map.put("image",resultSet.getString("image"));
                map.put("total_price",resultSet.getString("total_price"));
                map.put("order_time",resultSet.getString("order_time"));

                list.add(map);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


}
