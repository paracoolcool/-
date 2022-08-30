package dao.impl;

import Util.JDBCUtil;
import dao.UserDao;
import pojo.User;
import sun.security.provider.MD5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
public class UserDaoIpml implements UserDao {
    /***
     * 用户注册方法
     * @param phone 用户账号
     * @param name  用户名
     * @param password 用户密码
     * @return
     */
    @Override
    public boolean register(String phone, String name, String password) {
        String sql="select * from t_user where phone=?;";
        //操作数据库
        ResultSet rs = JDBCUtil.executeQuery(sql, phone);
        //判断数据库中是否有这个用户
        try {
            if (rs.next()){

                return false;
            }
            try {
                String sql1 = "INSERT INTO `store`.`t_user`(`phone`, `username`, `password`) VALUES (?,?,?);\n";


                JDBCUtil.executeUpdate(sql1,phone,name,password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
    /*
    * 登录方法
    * 先访问数据库查询用户是否存在
    * 将用户信息返回web层
    * */
    @Override
    public User login(String username, String password) {
        String sql="select * from t_user where phone=?;";
        //操作数据库
        ResultSet rs = JDBCUtil.executeQuery(sql, username);

        try{
            if(rs.next()){
                User user=new User();
                //数据库中获取每个字段的值
                int uid =rs.getInt("uid");
                int gender = rs.getInt("gender");
                String phone = rs.getString("phone");

                String password1 =rs.getString("password");
                String username1 =rs.getString("username");
                String email =rs.getString("email");
                String avatar =rs.getString("avatar");
                //给对象赋值
                user.setUid(uid);
                user.setGender(gender);
                user.setPhone(phone);
                user.setPassword(password1);
                user.setUsername(username1);
                user.setEmail(email);
                user.setAvatar(avatar);


                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    /***
     * 用户修改个人头像的方法
     * @param fname 传入要修改的头像图片的名称
     * @param id 用户的唯一标识id
     * @return 返回1则成功修改，0则失败
     */
    @Override
    public int changeImg(String fname, int id) {
        String sql = "UPDATE t_user SET avatar = ? WHERE uid = ?";
        JDBCUtil.executeUpdate(sql,fname,id);
        return 1;
    }
    /***
     * 根据id查询当前用户信息，该方法多用于用户信息发送修改后更新用户session信息
     * @param id 用户id
     * @return 用户信息
     */
    @Override
    public User uMsg(int id) {
        String sql = "select * from t_user where uid=?;";
        ResultSet rs = JDBCUtil.executeQuery(sql, id);

        try{
            if(rs.next()){
                User user=new User();
                //数据库中获取每个字段的值
                int uid =rs.getInt("uid");
                int gender = rs.getInt("gender");
                String phone = rs.getString("phone");

                String password1 =rs.getString("password");
                String username1 =rs.getString("username");
                String email =rs.getString("email");
                String avatar =rs.getString("avatar");
                //给对象赋值
                user.setUid(uid);
                user.setGender(gender);
                user.setPhone(phone);
                user.setPassword(password1);
                user.setUsername(username1);
                user.setEmail(email);
                user.setAvatar(avatar);


                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
