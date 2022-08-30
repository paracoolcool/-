package dao;

import pojo.User;

public interface UserDao {
//注册
    boolean register(String phone,String name, String password);
//登录
    User login(String username, String password);

    //修改头像
    int changeImg(String fname,int id);

    User uMsg(int id );
}
