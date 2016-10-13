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
        return prodOrderBO.saveProdOrder(data);
    }

    @Override
    public int takeProduct(String code, String taker, String takeNote) {
        ProdOrder data = prodOrderBO.getProdOrder(code);
        if (!EProdOrderStatus.PAY_YES.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "该订单已不是已支付状态");
        }
        return prodOrderBO.refreshProdOrderStatus(code,
            EProdOrderStatus.TAKE_YES.getCode(), taker, takeNote);
    }

    @Override
    public int invalidProdOrder(String code, String takeNote) {
        ProdOrder data = prodOrderBO.getProdOrder(code);
        if (!EProdOrderStatus.PAY_YES.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "该订单已不是已支付状态");
        }
        return prodOrderBO.refreshProdOrderStatus(code,
            EProdOrderStatus.INVALID.getCode(), null, takeNote);
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

    @Override
    public int editProdOrderStatus(String code) {
        if (!prodOrderBO.isProdOrderExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        ProdOrder data = new ProdOrder();
        data.setCode(code);
        data.setStatus(EProdOrderStatus.OBSOLETE.getCode());
        return prodOrderBO.refreshProdOrderStatus(data);
    }
}
