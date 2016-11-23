package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.forum.ao.IProductAO;
import com.std.forum.bo.IProdOrderBO;
import com.std.forum.bo.IProductBO;
import com.std.forum.bo.ISiteBO;
import com.std.forum.bo.IUserBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Product;
import com.std.forum.dto.res.XN610320Res;
import com.std.forum.dto.res.XN806010Res;
import com.std.forum.enums.EDirection;
import com.std.forum.enums.EProductStatus;
import com.std.forum.exception.BizException;

@Service
public class ProductAOImpl implements IProductAO {

    @Autowired
    private IProductBO productBO;

    @Autowired
    private IProdOrderBO prodOrderBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ISiteBO siteBO;

    @Override
    public String addProduct(Product data) {
        return productBO.saveProduct(data);
    }

    @Override
    public void dropProduct(String code) {
        Product data = productBO.getProduct(code);
        // 若产品状态不是未发布则不能删除
        if (!(EProductStatus.todoPUBLISH.getCode().equalsIgnoreCase(data
            .getStatus()))) {
            throw new BizException("xn0000", "只能删除未发布的产品");
        }
        productBO.removeProduct(code);
    }

    @Override
    public void editProduct(Product data) {
        // 若产品状态不是未发布则不能修改
        Product product = productBO.getProduct(data.getCode());
        if (!(EProductStatus.todoPUBLISH.getCode().equalsIgnoreCase(product
            .getStatus()))) {
            throw new BizException("xn0000", "只能修改未发布的产品");
        }
        productBO.refreshProduct(data);
    }

    @Override
    public void editProductStatus(String code, Long price) {
        Product data = productBO.getProduct(code);
        if (EProductStatus.todoPUBLISH.getCode().equalsIgnoreCase(
            data.getStatus())
                || EProductStatus.PUBLISH_NO.getCode().equalsIgnoreCase(
                    data.getStatus())) {
            // 若产品状态是未发布或已下架，则将改为已上架
            data.setStatus(EProductStatus.PUBLISH_YES.getCode());
        } else {
            // 若产品状态是已上架，则将改为已下架
            data.setStatus(EProductStatus.PUBLISH_NO.getCode());
        }
        data.setPrice(price);
        productBO.refreshProductStatus(data);
    }

    @Override
    @Transactional
    public XN610320Res exchangeProduct(String userId, String productCode,
            Integer quantity) {
        // 判断库存量
        Product product = productBO.getProduct(productCode);
        if (!EProductStatus.PUBLISH_YES.getCode().equals(product.getStatus())) {
            throw new BizException("xn0000", "该商品还未上架");
        }
        if (product.getQuantity() != null
                && (product.getQuantity() - quantity) < 0) {
            throw new BizException("xn0000", "该商品库存量不足，无法购买");
        }
        // 减去库存量
        productBO.refreshProductQuantity(productCode, quantity);
        XN806010Res site = siteBO.getCompany(product.getSiteCode());
        String takeAddress = site.getProvince() + " " + site.getCity() + " "
                + site.getArea() + " " + site.getAddress();
        // 新增订单
        Long totalPrice = product.getPrice() * quantity;
        String code = prodOrderBO.saveProdOrder(userId, productCode, quantity,
            totalPrice, "提货地点:" + takeAddress);
        // 扣除用户积分(必须放最后)
        userBO.doTransfer(userId, EDirection.MINUS.getCode(), totalPrice,
            "兑换商品:" + product.getName() + ",购买" + quantity + "件", code);
        return new XN610320Res(code, takeAddress);
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
}
