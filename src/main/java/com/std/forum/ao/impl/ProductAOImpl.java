package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IProductAO;
import com.std.forum.bo.IProductBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Product;
import com.std.forum.enums.EProductStatus;
import com.std.forum.exception.BizException;

@Service
public class ProductAOImpl implements IProductAO {

    @Autowired
    private IProductBO productBO;

    @Override
    public String addProduct(Product data) {
        return productBO.saveProduct(data);
    }

    @Override
    public int editProduct(Product data) {
        if (!productBO.isProductExist(data.getCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        // 若产品状态不是未发布则不能修改
        Product product = productBO.getProduct(data.getCode());
        if (!(EProductStatus.todoPUBLISH.getCode().equalsIgnoreCase(product
            .getStatus()))) {
            throw new BizException("xn0000", "只能修改未发布的产品");
        }
        return productBO.refreshProduct(data);
    }

    @Override
    public int dropProduct(String code) {
        if (!productBO.isProductExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        Product data = productBO.getProduct(code);
        // 若产品状态不是未发布则不能删除
        if (!(EProductStatus.todoPUBLISH.getCode().equalsIgnoreCase(data
            .getStatus()))) {
            throw new BizException("xn0000", "只能删除未发布的产品");
        }
        return productBO.removeProduct(code);
    }

    @Override
    public Paginable<Product> queryProductPage(int start, int limit,
            Product condition) {
        return productBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Product> queryProductList(Product condition) {
        return productBO.queryProductList(condition);
    }

    @Override
    public Product getProduct(String code) {
        return productBO.getProduct(code);
    }

    @Override
    public int editProductStatus(String code, Integer price) {
        if (!productBO.isProductExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        int count = 0;
        Product product = new Product();
        product.setCode(code);
        Product data = productBO.getProduct(code);
        // 若产品状态是未发布，则将改为已上架
        if (EProductStatus.todoPUBLISH.getCode().equalsIgnoreCase(
            data.getStatus())) {
            product.setStatus(EProductStatus.PUBLISH_YES.getCode());
            product.setPrice(price);
        }
        // 若产品状态是已下架，则将改为已上架
        if (EProductStatus.PUBLISH_NO.getCode().equalsIgnoreCase(
            data.getStatus())) {
            product.setStatus(EProductStatus.PUBLISH_YES.getCode());
            product.setPrice(price);
        }
        // 若产品状态是已上架，则将改为已下架
        if (EProductStatus.PUBLISH_YES.getCode().equalsIgnoreCase(
            data.getStatus())) {
            product.setStatus(EProductStatus.PUBLISH_NO.getCode());
            product.setPrice(price);
        }
        count = productBO.refreshProductStatus(product);
        return count;
    }
}
