package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Product;

public interface IProductAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addProduct(Product data);

    public int dropProduct(String code);

    public int editProduct(Product data);

    public int editProductStatus(String code, Long price);

    public Paginable<Product> queryProductPage(int start, int limit,
            Product condition);

    public List<Product> queryProductList(Product condition);

    public Product getProduct(String code);

}
