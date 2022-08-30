package dao.impl;

import Util.JDBCUtil;
import dao.OrderDao;
import pojo.Order;

import java.sql.ResultSet;
import java.util.Date;

public class OrderDaoImpl implements OrderDao {
    String sql = "";

    /***
     * 添加一条订单信息
     * @param uid 用户id
     * @param aid 地址id
     * @param sum 总数
     * @param time 下单时间
     * @return
     */
    @Override
    public int addOrder(int uid, int aid, long sum, Date time) {
        sql = "INSERT INTO t_order (uid,aid,total_price,order_time) VALUES (?,?,?,?)";
        int i = JDBCUtil.executeUpdate(sql, uid, aid, sum, time);
        return i;
    }

    /***
     * 查询当前时间生成的订单的id
     * @param timeStamp 时间
     * @return 订单id
     */
    @Override
    public Order getOrderBytime(String timeStamp) {
        sql="SELECT * FROM `t_order` WHERE order_time=?";
        ResultSet rs = JDBCUtil.executeQuery(sql, timeStamp);
        try{
            if(rs.next()){
                Order order = new Order();
                //数据库中获取每个字段的值
                int oid =rs.getInt("oid");

                //给对象赋值
                order.setOid(oid);


                return order;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
