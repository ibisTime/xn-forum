package com.std.forum.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.ISplateTemplateBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.ISplateTemplateDAO;
import com.std.forum.domain.SplateTemplate;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

@Component
public class SplateTemplateBOImpl extends PaginableBOImpl<SplateTemplate>
        implements ISplateTemplateBO {

    @Autowired
    private ISplateTemplateDAO splateTemplateDAO;

    @Override
    public boolean isSplateTemplateExist(String code) {
        SplateTemplate condition = new SplateTemplate();
        condition.setCode(code);
        if (splateTemplateDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveSplateTemplate(String name, String parentCode,
            String pic, String orderNo, String updater) {
        SplateTemplate data = new SplateTemplate();
        String code = OrderNoGenerater
            .generateME(EPrefixCode.SPLATEM.getCode());
        data.setCode(code);
        data.setName(name);
        data.setBplateCode(parentCode);
        data.setPic(pic);
        data.setOrderNo(orderNo);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        splateTemplateDAO.insert(data);
        return code;
    }

    @Override
    public int removeSplateTemplate(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            SplateTemplate data = new SplateTemplate();
            data.setCode(code);
            count = splateTemplateDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshSplateTemplate(String code, String name,
            String parentCode, String pic, String orderNo, String updater) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            SplateTemplate data = new SplateTemplate();
            data.setCode(code);
            data.setName(name);
            data.setBplateCode(parentCode);
            data.setPic(pic);
            data.setOrderNo(orderNo);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            count = splateTemplateDAO.update(data);
        }
        return count;
    }

    @Override
    public List<SplateTemplate> querySplateTemplateList(SplateTemplate condition) {
        return splateTemplateDAO.selectList(condition);
    }

    @Override
    public SplateTemplate getSplateTemplate(String code) {
        SplateTemplate data = null;
        if (StringUtils.isNotBlank(code)) {
            SplateTemplate condition = new SplateTemplate();
            condition.setCode(code);
            data = splateTemplateDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
