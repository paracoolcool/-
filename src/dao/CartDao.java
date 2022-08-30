package dao;



import java.util.List;
import java.util.Map;

public interface CartDao {
    int addCart(int uid,int pid,long price,int num);

    List<Map<String,String>> allCart(int uid);
    int deleteCart(int cid);
    int getPid(int cid);
}
