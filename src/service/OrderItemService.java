package service;

import java.util.List;
import java.util.Map;

public interface OrderItemService {
    int addAOItem(int oid,int pid,String title,String image,long price,int num);
    List<Map<String,String>> allOrderItem(int uid);

}
