package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Product;
import com.std.forum.dto.res.XN610320Res;

public interface IProductAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addProduct(Product data);

    public void dropProduct(String code);

    public void editProduct(Product data);

    public void editProductStatus(String code, Long price);

    public XN610320Res exchangeProduct(String userId, String productCode,
            Integer quantity);

    public Paginable<Product> queryProductPage(int start, int limit,
            Product condition);

    public List<Product> queryProductList(Product condition);

    public Product getProduct(String code);

}
