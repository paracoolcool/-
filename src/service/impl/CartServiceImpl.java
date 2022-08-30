package service.impl;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import service.CartService;

import javax.lang.model.element.VariableElement;
import java.util.List;
import java.util.Map;

public class CartServiceImpl implements CartService {
    CartDao cd = new CartDaoImpl();

    /***
     * 添加一条购物车记录
     * @param uid 当前登录用户id
     * @param pid 商品id
     * @param price 商品价格
     * @param num 数量
     * @return
     */
    @Override
    public int addCart(int uid, int pid, long price, int num) {
        int i = cd.addCart(uid, pid, price, num);
        return i;
    }
    /***
     * 查询当前用户的购物车信息列表
     * @param uid 用户id
     * @return 购物车列表
     */
    @Override
    public List<Map<String, String>> allCart(int uid) {
        List<Map<String, String>> list = cd.allCart(uid);
        return list;
    }

    /***
     * 删除一条购物车记录
     * @param cid 购物车记录id
     * @return 删除结果
     */
    @Override
    public int deleteCart(int cid) {
        int i = cd.deleteCart(cid);
        return i;
    }

    @Override
    public int getPid(int cid) {
        int pid = cd.getPid(cid);
        return pid;
    }
}
