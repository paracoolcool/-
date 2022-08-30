package dao.impl;

import Util.JDBCUtil;
import dao.ProductDao;
import pojo.Product;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    /***
     *查询数据库中所有商品
     */
    @Override
    public List<Product> getProduct() {
        String sql="select * from t_product;";
        ResultSet resultSet = JDBCUtil.executeQuery(sql);
        List<Product> list = new ArrayList<>();

        try {
            while (resultSet.next()){
                Product product = new Product();
                int id = resultSet.getInt("id");
                int category_id = resultSet.getInt("category_id");
                int status = resultSet.getInt("status");
                int priority = resultSet.getInt("priority");
                String item_type = resultSet.getString("item_type");
                String title = resultSet.getString("title");
                String sell_point = resultSet.getString("sell_point");
                String image = resultSet.getString("image");
                String created_user = resultSet.getString("created_user");
                String modified_user = resultSet.getString("modified_user");
                long price = resultSet.getLong("price");

                product.setId(id);
                product.setCategory_id(category_id);
                product.setStatus(status);
                product.setPriority(priority);
                product.setItem_type(item_type);
                product.setTitle(title);
                product.setSell_point(sell_point);
                product.setImage(image);
                product.setCreated_user(created_user);
                product.setModified_user(modified_user);
                product.setPrice(price);
                list.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /***
     * 获取id商品的信息
     * @param id 商品id
     * @return 商品信息对象
     */
    @Override
    public Product productDetail(String id) {
        String sql = "SELECT * FROM `t_product` WHERE id=?";
        ResultSet rs = JDBCUtil.executeQuery(sql, id);
        try{
            if(rs.next()){
                Product product=new Product();
                //数据库中获取每个字段的值
                int id1 =rs.getInt("id");
                int category_id = rs.getInt("category_id");
                String item_type = rs.getString("item_type");
                long price = rs.getLong("price");
                String title =rs.getString("title");
                String sell_point =rs.getString("sell_point");
                String image =rs.getString("image");
                int num =rs.getInt("num");
                //给对象赋值
                product.setId(id1);
                product.setCategory_id(category_id);
                product.setItem_type(item_type);
                product.setTitle(title);
                product.setSell_point(sell_point);
                product.setImage(image);
                product.setNum(num);
                product.setPrice(price);

                return product;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    /***
     * 商品的模糊搜素方法
     * @param title 输入的关键字
     * @return 结果
     */
    @Override
    public List<Product> quickSearch(String title) {
        String sql = "SELECT * FROM t_product WHERE title LIKE ?";
        ResultSet resultSet = JDBCUtil.executeQuery(sql, "%"+title+"%");
        List<Product> list = new ArrayList<>();

        try {
            while (resultSet.next()){
                Product product = new Product();
                int id = resultSet.getInt("id");
                int category_id = resultSet.getInt("category_id");
                int status = resultSet.getInt("status");
                int priority = resultSet.getInt("priority");
                String item_type = resultSet.getString("item_type");
                String title1 = resultSet.getString("title");
                String sell_point = resultSet.getString("sell_point");
                String image = resultSet.getString("image");
                String created_user = resultSet.getString("created_user");
                String modified_user = resultSet.getString("modified_user");
                long price = resultSet.getLong("price");

                product.setId(id);
                product.setCategory_id(category_id);
                product.setStatus(status);
                product.setPriority(priority);
                product.setItem_type(item_type);
                product.setTitle(title1);
                product.setSell_point(sell_point);
                product.setImage(image);
                product.setCreated_user(created_user);
                product.setModified_user(modified_user);
                product.setPrice(price);
                list.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
