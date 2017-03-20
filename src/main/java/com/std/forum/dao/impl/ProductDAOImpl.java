package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.IProductDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Product;

@Repository("productDAOImpl")
public class ProductDAOImpl extends AMybatisTemplate implements IProductDAO {

    @Override
    public int insert(Product data) {
        return super.insert(NAMESPACE.concat("insert_product"), data);
    }

    @Override
    public int delete(Product data) {
        return super.delete(NAMESPACE.concat("delete_product"), data);
    }

    @Override
    public Product select(Product condition) {
        return super.select(NAMESPACE.concat("select_product"), condition,
            Product.class);
    }

    @Override
    public Long selectTotalCount(Product condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_product_count"),
            condition);
    }

    @Override
    public List<Product> selectList(Product condition) {
        return super.selectList(NAMESPACE.concat("select_product"), condition,
            Product.class);
    }

    @Override
    public List<Product> selectList(Product condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_product"), start,
            count, condition, Product.class);
    }

    @Override
    public int update(Product data) {
        return super.update(NAMESPACE.concat("update_product"), data);
    }

    @Override
    public int updateStatus(Product data) {
        return super.update(NAMESPACE.concat("update_product_status"), data);
    }

    /** 
     * @see com.std.forum.dao.IProductDAO#updateQuantity(com.std.forum.domain.Product)
     */
    @Override
    public int updateQuantity(Product data) {
        return super.update(NAMESPACE.concat("update_product_quantity"), data);
    }
}
