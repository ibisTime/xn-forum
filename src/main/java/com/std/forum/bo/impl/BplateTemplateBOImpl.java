package com.std.forum.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IBplateTemplateBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IBplateTemplateDAO;
import com.std.forum.domain.BplateTemplate;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

@Component
public class BplateTemplateBOImpl extends PaginableBOImpl<BplateTemplate>
        implements IBplateTemplateBO {

    @Autowired
    private IBplateTemplateDAO bplateTemplateDAO;

    @Override
    public boolean isBplateTemplateExist(String code) {
        BplateTemplate condition = new BplateTemplate();
        condition.setCode(code);
        if (bplateTemplateDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBplateTemplate(String name, String orderNo, String updater) {
        BplateTemplate data = new BplateTemplate();
        String code = OrderNoGenerater
            .generateME(EPrefixCode.BPLATEM.getCode());
        data.setCode(code);
        data.setName(name);
        data.setOrderNo(orderNo);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        bplateTemplateDAO.insert(data);
        return code;
    }

    @Override
    public int removeBplateTemplate(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BplateTemplate data = new BplateTemplate();
            data.setCode(code);
            count = bplateTemplateDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBplateTemplate(String code, String name, String orderNo,
            String updater) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BplateTemplate data = new BplateTemplate();
            data.setCode(code);
            data.setName(name);
            data.setOrderNo(orderNo);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            count = bplateTemplateDAO.update(data);
        }
        return count;
    }

    @Override
    public List<BplateTemplate> queryBplateTemplateList(BplateTemplate condition) {
        return bplateTemplateDAO.selectList(condition);
    }

    @Override
    public BplateTemplate getBplateTemplate(String code) {
        BplateTemplate data = null;
        if (StringUtils.isNotBlank(code)) {
            BplateTemplate condition = new BplateTemplate();
            condition.setCode(code);
            data = bplateTemplateDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "大模板编号不存在");
            }
        }
        return data;
    }
}
