package com.std.forum.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IBplateBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IBplateDAO;
import com.std.forum.domain.Bplate;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

@Component
public class BplateBOImpl extends PaginableBOImpl<Bplate> implements IBplateBO {

    @Autowired
    private IBplateDAO bplateDAO;

    @Override
    public boolean isBplateExist(String code) {
        Bplate condition = new Bplate();
        condition.setCode(code);
        if (bplateDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBplate(String name, String status, String orderNo,
            String companyCode, String updater) {
        Bplate data = new Bplate();
        String code = OrderNoGenerater.generateME(EPrefixCode.BPLATE.getCode());
        data.setCode(code);
        data.setName(name);
        data.setStatus(status);
        data.setOrderNo(orderNo);
        data.setCompanyCode(companyCode);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        bplateDAO.insert(data);
        return code;
    }

    @Override
    public int removeBplate(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Bplate data = new Bplate();
            data.setCode(code);
            count = bplateDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBplate(String code, String name, String status,
            String orderNo, String companyCode, String updater) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Bplate data = new Bplate();
            data.setCode(code);
            data.setName(name);
            data.setStatus(status);
            data.setOrderNo(orderNo);
            data.setCompanyCode(companyCode);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            count = bplateDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Bplate> queryBplateList(Bplate condition) {
        return bplateDAO.selectList(condition);
    }

    @Override
    public Bplate getBplate(String code) {
        Bplate data = null;
        if (StringUtils.isNotBlank(code)) {
            Bplate condition = new Bplate();
            condition.setCode(code);
            data = bplateDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
