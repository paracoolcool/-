package dao;

import pojo.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProduct();

    Product productDetail(String id);

    List<Product> quickSearch(String title);
}
