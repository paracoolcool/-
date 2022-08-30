package service;

import pojo.User;

public interface UserService {
//    注册
    boolean register(String phone, String name,String password);

    //登录
    User login(String username, String password);

    User uMsg(int id);
    //修改头像
    int changeImg(String fname,int id);
}
