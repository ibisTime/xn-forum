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
import com.std.forum.exception.BizException;

@Service
public class ProdOrderAOImpl implements IProdOrderAO {

    @Autowired
    private IProdOrderBO prodOrderBO;

    @Autowired
    private IProductBO productBO;

    @Autowired
    private IUserBO userBO;

    @Override
    @Transactional
    public String addProdOrder(String userId, String productCode,
            Integer quantity) {
        String code = null;
        // 判断库存量
        Product product = productBO.getProduct(productCode);
        if (product.getQuantity() != null && product.getQuantity() == 0) {
            throw new BizException("xn0000", "该商品库存量不足，无法购买");
        }
        // 减去库存量
        productBO.refreshProductQuantity(productCode, quantity);
        Long totalPrice = product.getPrice() * quantity;
        code = prodOrderBO.saveProdOrder(userId, productCode, quantity,
            totalPrice);
        // 扣除用户积分
        userBO.doTransfer(userId, EDirection.MINUS.getCode(), totalPrice,
            "兑换商品:[" + product.getName() + ",购买" + quantity + "件]", code);
        return code;
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
    @Transactional
    public void invalidProdOrder(String code, String takeNote) {
        ProdOrder data = prodOrderBO.getProdOrder(code);
        if (!EProdOrderStatus.PAY_YES.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "该订单已不是已支付状态");
        }
        prodOrderBO.refreshProdOrderStatus(code,
            EProdOrderStatus.INVALID.getCode(), null, takeNote);
        // 订单作废，退还积分
        Product product = productBO.getProduct(data.getProductCode());
        userBO.doTransfer(data.getPayer(), EDirection.PLUS.getCode(),
            data.getPayPrice(),
            "退还商品:[" + product.getName() + "，退还积分" + data.getPayPrice() / 1000,
            code);
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
