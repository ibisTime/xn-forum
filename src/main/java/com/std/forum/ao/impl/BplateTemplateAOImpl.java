package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IBplateTemplateAO;
import com.std.forum.bo.IBplateTemplateBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.BplateTemplate;
import com.std.forum.exception.BizException;

@Service
public class BplateTemplateAOImpl implements IBplateTemplateAO {

    @Autowired
    private IBplateTemplateBO bplateTemplateBO;

    @Override
    public String addBplateTemplate(String name, String orderNo, String updater) {
        return bplateTemplateBO.saveBplateTemplate(name, orderNo, updater);
    }

    @Override
    public int editBplateTemplate(String code, String name, String orderNo,
            String updater) {
        if (!bplateTemplateBO.isBplateTemplateExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return bplateTemplateBO.refreshBplateTemplate(code, name, orderNo,
            updater);
    }

    @Override
    public int dropBplateTemplate(String code) {
        if (!bplateTemplateBO.isBplateTemplateExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return bplateTemplateBO.removeBplateTemplate(code);
    }

    @Override
    public Paginable<BplateTemplate> queryBplateTemplatePage(int start,
            int limit, BplateTemplate condition) {
        return bplateTemplateBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BplateTemplate> queryBplateTemplateList(BplateTemplate condition) {
        return bplateTemplateBO.queryBplateTemplateList(condition);
    }

    @Override
    public BplateTemplate getBplateTemplate(String code) {
        return bplateTemplateBO.getBplateTemplate(code);
    }
}
