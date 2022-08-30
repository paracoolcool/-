package service.impl;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import pojo.Order;
import service.OrderService;

import java.sql.Timestamp;
import java.util.Date;

public class OrderServiceImpl implements OrderService {
    OrderDao od = new OrderDaoImpl();
    @Override
    public int addOrder(int uid, int aid, long sum, Date time) {
        int i = od.addOrder(uid, aid, sum, time);
        return i;
    }

    @Override
    public Order getOrderBytime(String timeStamp) {
        Order order = od.getOrderBytime(timeStamp);
        return order;
    }
}
