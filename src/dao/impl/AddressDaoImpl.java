package dao.impl;

import Util.JDBCUtil;
import dao.AddressDao;
import pojo.Address;
import pojo.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    private String sql;
    /***
     * 新增一个收货地址的方法
     * @param name 收货人姓名
     * @param phone 收货人电话
     * @param sheng 省份/直辖市
     * @param city 城市
     * @param area 区县
     * @param add_msg 详细地址
     * @param type 类型
     * @param uid 用户id
     * @return i i不等于0时代表数据库中有数据被影响
     */
    @Override
    public int addAddress(String name, String phone, String sheng, String city, String add_msg, String type, String area, int uid) {
        sql = "INSERT INTO `store`.`t_address`(`uid`, `name`, `province_name`, `city_name`, `area_name`, `address`, `phone`, `tag`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        int i = JDBCUtil.executeUpdate(sql, uid, name, sheng, city, area, add_msg, phone, type);
        return i;
    }

    /***
     * 查询出登录用户的地址信息
     * @param uid 登录用户id
     * @return 地址列表
     */
    @Override
    public List<Address> findAddByuid(int uid) {
        sql = "SELECT * FROM `t_address` WHERE uid =?";
        ResultSet rs = JDBCUtil.executeQuery(sql, uid);
        List<Address> list = new ArrayList<>();
        try {
            while (rs.next()){
                Address address = new Address();
                int aid =rs.getInt("aid");
                int uid1 = rs.getInt("uid");
                String name = rs.getString("name");
                String proname = rs.getString("province_name");
                String city_nameproname = rs.getString("city_name");
                String area_name = rs.getString("area_name");
                String address1 = rs.getString("address");
                String phone = rs.getString("phone");
                String tag = rs.getString("tag");
                address.setAid(aid);
                address.setUid(uid1);
                address.setName(name);
                address.setProvince_name(proname);
                address.setCity_name(city_nameproname);
                address.setArea_name(area_name);
                address.setAddress(address1);
                address.setPhone(phone);
                address.setTag(tag);
                list.add(address);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    /***
     * 删除一条收货地址信息
     * @param aid 要删除的地址id
     * @return  删除结果
     */
    @Override
    public int deleteAddress(int aid) {
        sql = "DELETE FROM t_address WHERE aid=?";
        int i = JDBCUtil.executeUpdate(sql, aid);
        return i;
    }
}
