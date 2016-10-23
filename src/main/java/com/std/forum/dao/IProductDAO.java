package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Product;

public interface IProductDAO extends IBaseDAO<Product> {
    String NAMESPACE = IProductDAO.class.getName().concat(".");

    public int update(Product data);

    public int updateStatus(Product data);

    public int updateQuantity(Product data);
}
