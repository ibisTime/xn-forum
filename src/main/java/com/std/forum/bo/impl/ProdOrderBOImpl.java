package com.std.forum.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IProdOrderBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IProdOrderDAO;
import com.std.forum.domain.ProdOrder;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.enums.EProdOrderStatus;
import com.std.forum.exception.BizException;

@Component
public class ProdOrderBOImpl extends PaginableBOImpl<ProdOrder> implements
        IProdOrderBO {

    @Autowired
    private IProdOrderDAO prodOrderDAO;

    @Override
    public boolean isProdOrderExist(String code) {
        ProdOrder condition = new ProdOrder();
        condition.setCode(code);
        if (prodOrderDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveProdOrder(String userId, String productCode,
            Integer quantity, Long payPrice, String remark) {
        String code = null;
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(productCode)) {
            code = OrderNoGenerater.generate(EPrefixCode.PRODORDER.getCode());
            ProdOrder data = new ProdOrder();
            data.setCode(code);
            data.setProductCode(productCode);
            data.setPayPrice(payPrice);
            data.setQuantity(quantity);
            data.setStatus(EProdOrderStatus.PAYED.getCode());
            data.setPayer(userId);
            data.setPayDatetime(new Date());
            data.setRemark(remark);
            prodOrderDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeProdOrder(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ProdOrder data = new ProdOrder();
            data.setCode(code);
            count = prodOrderDAO.delete(data);
        }
        return count;
    }

    @Override
    public ProdOrder refreshStatus(String code, EProdOrderStatus toStatus,
            String takeNote) {
        ProdOrder data = this.getProdOrder(code);
        if (!EProdOrderStatus.PAYED.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "该订单已不是已支付状态");
        }
        data.setStatus(toStatus.getCode());
        data.setTakeDatetime(new Date());
        data.setRemark(takeNote);
        prodOrderDAO.update(data);
        return data;
    }

    @Override
    public List<ProdOrder> queryProdOrderList(ProdOrder condition) {
        return prodOrderDAO.selectList(condition);
    }

    @Override
    public ProdOrder getProdOrder(String code) {
        ProdOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            ProdOrder condition = new ProdOrder();
            condition.setCode(code);
            data = prodOrderDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "订单编号不存在");
            }
        }
        return data;
    }
}
