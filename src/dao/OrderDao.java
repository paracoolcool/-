package dao;

import pojo.Order;

import java.util.Date;

public interface OrderDao {
    int addOrder(int uid, int aid, long sum, Date time);

    Order getOrderBytime(String timeStamp);
}
