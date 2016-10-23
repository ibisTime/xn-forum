package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Product;

public interface IProductBO extends IPaginableBO<Product> {

    public boolean isProductExist(String code);

    public String saveProduct(Product data);

    public int removeProduct(String code);

    public int refreshProduct(Product data);

    public int refreshProductStatus(Product data);

    public int refreshProductQuantity(String code, Integer quantity);

    public List<Product> queryProductList(Product condition);

    public Product getProduct(String code);

}
