package service.impl;

import dao.AddressDao;
import dao.impl.AddressDaoImpl;
import pojo.Address;
import service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao ad = new AddressDaoImpl();

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
     * @return
     */
    @Override
    public int addAddress(String name, String phone, String sheng, String city, String add_msg, String type,String area, int uid) {
        int i = ad.addAddress(name, phone, sheng, city, add_msg, type,area, uid);
        return i;
    }

    /***
     * 查询当前登录用户的已有收货地址列表
     * @param uid 当前登录用户的id
     * @return 收货地址列表
     */
    @Override
    public List<Address> findAddByuid(int uid) {
        List<Address> list = ad.findAddByuid(uid);
        return list;
    }

    /***
     * 删除一条收货地址信息
     * @param aid 要删除的地址id
     * @return  删除结果
     */
    @Override
    public int deleteAddress(int aid) {
        int i = ad.deleteAddress(aid);
        return i;
    }
}
