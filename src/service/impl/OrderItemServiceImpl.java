package service.impl;

import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import service.OrderItemService;

import java.util.List;
import java.util.Map;

public class OrderItemServiceImpl implements OrderItemService {
    OrderItemDao dao= new OrderItemDaoImpl();
    @Override
    public int addAOItem(int oid, int pid, String title, String image, long price, int num) {
        int i = dao.addAOItem(oid, pid, title, image, price, num);
        return i;
    }

    @Override
    public List<Map<String, String>> allOrderItem(int uid) {
        List<Map<String, String>> list = dao.allOrderItem(uid);
        return list;
    }
}
