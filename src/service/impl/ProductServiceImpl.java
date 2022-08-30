package service.impl;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import pojo.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao pd = new ProductDaoImpl();

    /***
     * 获取所有商品信息
     * @return 所有商品信息集合
     */
    @Override
    public List<Product> getProducts() {
        List<Product> productIterable = pd.getProduct();
        return productIterable;
    }

    /***
     *  获取单一商品信息的方法
     * @param id 商品的唯一id
     * @return  该商品对象信息
     */
    @Override
    public Product productDetail(String id) {
        Product product = pd.productDetail(id);
        return product;
    }

    @Override
    public List<Product> quickSearch(String title) {
        List<Product> list = pd.quickSearch(title);
        return list;
    }
}
