package service;

import pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product productDetail(String id);

    List<Product> quickSearch(String title);
}
