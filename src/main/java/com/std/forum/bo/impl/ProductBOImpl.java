package com.std.forum.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IProductBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IProductDAO;
import com.std.forum.domain.Product;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.enums.EProductStatus;
import com.std.forum.exception.BizException;

@Component
public class ProductBOImpl extends PaginableBOImpl<Product> implements
        IProductBO {

    @Autowired
    private IProductDAO productDAO;

    @Override
    public boolean isProductExist(String code) {
        Product condition = new Product();
        condition.setCode(code);
        if (productDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveProduct(Product data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EPrefixCode.PRODUCT.getCode());
            data.setCode(code);
            data.setStatus(EProductStatus.todoPUBLISH.getCode());
            productDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeProduct(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Product data = new Product();
            data.setCode(code);
            count = productDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshProduct(Product data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = productDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Product> queryProductList(Product condition) {
        return productDAO.selectList(condition);
    }

    @Override
    public Product getProduct(String code) {
        Product data = null;
        if (StringUtils.isNotBlank(code)) {
            Product condition = new Product();
            condition.setCode(code);
            data = productDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "商品编号不存在");
            }
        }
        return data;
    }

    @Override
    public int refreshProductStatus(Product data) {
        return productDAO.updateStatus(data);
    }

    @Override
    public int refreshProductQuantity(String code, Integer quantity) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Product data = new Product();
            data.setCode(code);
            data.setQuantity(quantity);
            count = productDAO.updateQuantity(data);
        }
        return count;
    }
}
