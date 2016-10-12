package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IProdOrderAO;
import com.std.forum.bo.IProdOrderBO;
import com.std.forum.bo.IProductBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.ProdOrder;
import com.std.forum.domain.Product;
import com.std.forum.enums.EProdOrderStatus;
import com.std.forum.exception.BizException;

@Service
public class ProdOrderAOImpl implements IProdOrderAO {

    @Autowired
    private IProdOrderBO prodOrderBO;

    @Autowired
    private IProductBO productBO;

    @Override
    public String addProdOrder(ProdOrder data) {
        Product product = productBO.getProduct(data.getProductCode());
        // 计算产品总价格
        Integer price = product.getPrice() * data.getQuantity();
        data.setPayPrice(price);
        // 状态设为 已支付
        data.setStatus("1");
        return prodOrderBO.saveProdOrder(data);
    }

    @Override
    public int editProdOrder(ProdOrder data) {
        if (!prodOrderBO.isProdOrderExist(data.getCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        ProdOrder prodOrder = prodOrderBO.getProdOrder(data.getCode());
        if (EProdOrderStatus.todoPAY.getCode().equalsIgnoreCase(
            prodOrder.getStatus())) {
            throw new BizException("xn0000", "该订单未支付，不能提货");
        }
        return prodOrderBO.refreshProdOrder(data);
    }

    @Override
    public int dropProdOrder(String code) {
        if (!prodOrderBO.isProdOrderExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return prodOrderBO.removeProdOrder(code);
    }

    @Override
    public Paginable<ProdOrder> queryProdOrderPage(int start, int limit,
            ProdOrder condition) {
        return prodOrderBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<ProdOrder> queryProdOrderList(ProdOrder condition) {
        return prodOrderBO.queryProdOrderList(condition);
    }

    @Override
    public ProdOrder getProdOrder(String code) {
        return prodOrderBO.getProdOrder(code);
    }
}
