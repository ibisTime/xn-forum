package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.forum.ao.IProdOrderAO;
import com.std.forum.bo.IProdOrderBO;
import com.std.forum.bo.IProductBO;
import com.std.forum.bo.IUserBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.ProdOrder;
import com.std.forum.domain.Product;
import com.std.forum.enums.EDirection;
import com.std.forum.enums.EProdOrderStatus;

@Service
public class ProdOrderAOImpl implements IProdOrderAO {

    @Autowired
    private IProdOrderBO prodOrderBO;

    @Autowired
    private IProductBO productBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public void takeYes(String code, String takeNote) {
        prodOrderBO.refreshStatus(code, EProdOrderStatus.TAKE_YES, takeNote);
    }

    @Override
    @Transactional
    public void takeNo(String code, String takeNote) {
        ProdOrder data = prodOrderBO.refreshStatus(code,
            EProdOrderStatus.TAKE_NO, takeNote);
        // 订单作废，退还积分
        Product product = productBO.getProduct(data.getProductCode());
        userBO.doTransfer(data.getPayer(), EDirection.PLUS.getCode(),
            data.getPayPrice(), "退还商品:" + product.getName(), code);
    }

    @Override
    public Paginable<ProdOrder> queryProdOrderPage(int start, int limit,
            ProdOrder condition) {
        Paginable<ProdOrder> page = prodOrderBO.getPaginable(start, limit,
            condition);
        List<ProdOrder> list = page.getList();
        for (ProdOrder prodOrder : list) {
            prodOrder.setProduct(productBO.getProduct(prodOrder
                .getProductCode()));
        }
        return page;
    }

    @Override
    public List<ProdOrder> queryProdOrderList(ProdOrder condition) {
        List<ProdOrder> list = prodOrderBO.queryProdOrderList(condition);
        for (ProdOrder prodOrder : list) {
            prodOrder.setProduct(productBO.getProduct(prodOrder
                .getProductCode()));
        }
        return list;
    }

    @Override
    public ProdOrder getProdOrder(String code) {
        ProdOrder prodOrder = prodOrderBO.getProdOrder(code);
        prodOrder.setProduct(productBO.getProduct(prodOrder.getProductCode()));
        return prodOrder;
    }
}
