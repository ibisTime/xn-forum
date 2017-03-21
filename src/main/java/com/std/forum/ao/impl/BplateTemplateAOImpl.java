package com.std.forum.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.forum.ao.IBplateTemplateAO;
import com.std.forum.bo.IBplateTemplateBO;
import com.std.forum.bo.ISplateTemplateBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.BplateTemplate;
import com.std.forum.domain.SplateTemplate;
import com.std.forum.exception.BizException;

@Service
public class BplateTemplateAOImpl implements IBplateTemplateAO {

    @Autowired
    private IBplateTemplateBO bplateTemplateBO;

    @Autowired
    private ISplateTemplateBO splateTemplateBO;

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
    @Transactional
    public int dropBplateTemplate(String code) {
        if (!bplateTemplateBO.isBplateTemplateExist(code)) {
            throw new BizException("xn0000", "大板块模板不存在");
        }
        List<SplateTemplate> splateTemplateList = splateTemplateBO
            .querySplateTemplateList(code);
        if (CollectionUtils.isNotEmpty(splateTemplateList)) {
            for (SplateTemplate splateTemplate : splateTemplateList) {
                splateTemplateBO.removeSplateTemplate(splateTemplate.getCode());
            }
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
