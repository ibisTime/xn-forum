package com.std.forum.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.ISubsystemBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.ISubsystemDAO;
import com.std.forum.domain.Subsystem;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

@Component
public class SubsystemBOImpl extends PaginableBOImpl<Subsystem> implements
        ISubsystemBO {

    @Autowired
    private ISubsystemDAO subsystemDAO;

    @Override
    public boolean isSubsystemExist(String code) {
        Subsystem condition = new Subsystem();
        condition.setCode(code);
        if (subsystemDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveSubsystem(String name, String url, String pic,
            String location, String orderNo, String companyCode, String remark) {
        Subsystem data = new Subsystem();
        String code = OrderNoGenerater.generateME(EPrefixCode.SUBSYSTEM
            .getCode());
        data.setCode(code);
        data.setName(name);
        data.setUrl(url);
        data.setPic(pic);
        data.setLocation(location);
        data.setOrderNo(orderNo);
        data.setCompanyCode(companyCode);
        data.setRemark(remark);
        subsystemDAO.insert(data);
        return code;
    }

    @Override
    public int removeSubsystem(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Subsystem data = new Subsystem();
            data.setCode(code);
            count = subsystemDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshSubsystem(String code, String name, String url,
            String pic, String location, String orderNo, String companyCode,
            String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Subsystem data = new Subsystem();
            data.setCode(code);
            data.setName(name);
            data.setUrl(url);
            data.setPic(pic);
            data.setLocation(location);
            data.setOrderNo(orderNo);
            data.setCompanyCode(companyCode);
            data.setRemark(remark);
            count = subsystemDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Subsystem> querySubsystemList(Subsystem condition) {
        return subsystemDAO.selectList(condition);
    }

    @Override
    public List<Subsystem> querySubsystemList(String companyCode) {
        Subsystem condition = new Subsystem();
        condition.setCompanyCode(companyCode);
        return subsystemDAO.selectList(condition);
    }

    @Override
    public Subsystem getSubsystem(String code) {
        Subsystem data = null;
        if (StringUtils.isNotBlank(code)) {
            Subsystem condition = new Subsystem();
            condition.setCode(code);
            data = subsystemDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

}
