package service;

import pojo.Order;

import java.sql.Timestamp;
import java.util.Date;

public interface OrderService {
    int addOrder(int uid, int aid, long sum, Date time);

    Order getOrderBytime(String timeStamp);
}
