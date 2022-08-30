package service.impl;

import Util.Md5Util;
import dao.UserDao;
import dao.impl.UserDaoIpml;
import pojo.User;
import service.UserService;

import static Util.Md5Util.string2MD5;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoIpml();
//注册
    @Override
    public boolean register(String phone, String name,String password) {
        boolean register = userDao.register(phone,name, password);
        return register;
    }
//    登录
    @Override
    public User login(String username, String password) {
        User  user = userDao.login(username,password);

        String s1 = string2MD5(password);
        if (!user.getPassword().equals(s1)){
            //如果用户输入的账号存在，但密码不正确，返回null
            return null;
        }
        return user;
    }

    /***
     * 根据id查询当前用户信息，该方法多用于用户信息发送修改后更新用户session信息
     * @param id 用户id
     * @return 用户信息
     */
    @Override
    public User uMsg(int id) {
        User user = userDao.uMsg(id);
        return user;
    }

    //  修改头像的方法
    @Override
    public int changeImg(String fname,int id) {
        int i = userDao.changeImg(fname, id);
        return i;
    }
}
