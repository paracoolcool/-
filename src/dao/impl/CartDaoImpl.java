package dao.impl;

import Util.JDBCUtil;
import dao.CartDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDaoImpl implements CartDao {
    String sql = "";

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
        sql = "INSERT INTO t_cart (uid,pid,price,num) VALUES (?,?,?,?)";
        int i = JDBCUtil.executeUpdate(sql, uid, pid, price, num);
        return i;
    }

    /***
     * 查询当前用户的购物车信息列表
     * @param uid 用户id
     * @return 购物车列表
     */
    @Override
    public List<Map<String, String>> allCart(int uid) {
        sql = "SELECT p.title,c.cid,c.price,c.num FROM `t_cart` c, t_product p WHERE p.id=c.pid AND uid=?";
        ResultSet resultSet = JDBCUtil.executeQuery(sql, uid);
        List<Map<String,String>> list=new ArrayList<Map<String, String>>();
        try {
            while (resultSet.next()){

                Map<String,String> map = new HashMap<>();
                map.put("cid",resultSet.getString("cid"));
                map.put("title",resultSet.getString("title"));
                map.put("price",resultSet.getString("price"));
                map.put("num",resultSet.getString("num"));
                list.add(map);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    /***
     * 删除一条购物车记录
     * @param cid 购物车记录id
     * @return 删除结果
     */
    @Override
    public int deleteCart(int cid) {
        sql = "DELETE FROM t_cart WHERE cid=?";
        int i = JDBCUtil.executeUpdate(sql, cid);
        return i;
    }

    /***
     * 通过购物车id获取商品id
     * @param cid 购物车id
     * @return 商品id
     */
    @Override
    public int getPid(int cid) {
        sql="SELECT pid FROM t_cart WHERE cid=?";
        ResultSet resultSet = JDBCUtil.executeQuery(sql, cid);
        try {
            if(resultSet.next()){
            int pid = resultSet.getInt("pid");
            return pid;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
