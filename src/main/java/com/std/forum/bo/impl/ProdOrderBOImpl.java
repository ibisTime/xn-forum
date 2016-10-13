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

//CHECK ��鲢��ע�� 
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
    public String saveProdOrder(ProdOrder data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EPrefixCode.PRODORDER.getCode());
            data.setCode(code);
            data.setStatus(EProdOrderStatus.PAY_YES.getCode());
            data.setPayDatetime(new Date());
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
    public int refreshProdOrderStatus(String code, String status, String taker,
            String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ProdOrder data = new ProdOrder();
            data.setCode(code);
            data.setStatus(status);
            data.setTaker(taker);
            data.setTakeDatetime(new Date());
            data.setRemark(remark);
            count = prodOrderDAO.update(data);
        }
        return count;
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
                throw new BizException("xn0000", "该编号不存在");
            }
        }
        return data;
    }
}
