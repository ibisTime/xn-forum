package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.ISplateTemplateAO;
import com.std.forum.bo.ISplateTemplateBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.SplateTemplate;
import com.std.forum.exception.BizException;

@Service
public class SplateTemplateAOImpl implements ISplateTemplateAO {

    @Autowired
    private ISplateTemplateBO splateTemplateBO;

    @Override
    public String addSplateTemplate(String name, String parentCode, String pic,
            String orderNo, String updater) {
        return splateTemplateBO.saveSplateTemplate(name, parentCode, pic,
            orderNo, updater);
    }

    @Override
    public int editSplateTemplate(String code, String name, String parentCode,
            String pic, String orderNo, String updater) {
        if (!splateTemplateBO.isSplateTemplateExist(code)) {
            throw new BizException("xn0000", "小版块模板编号不存在");
        }
        return splateTemplateBO.refreshSplateTemplate(code, name, parentCode,
            pic, orderNo, updater);
    }

    @Override
    public int dropSplateTemplate(String code) {
        if (!splateTemplateBO.isSplateTemplateExist(code)) {
            throw new BizException("xn0000", "小版块模板编号不存在");
        }
        return splateTemplateBO.removeSplateTemplate(code);
    }

    @Override
    public Paginable<SplateTemplate> querySplateTemplatePage(int start,
            int limit, SplateTemplate condition) {
        return splateTemplateBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<SplateTemplate> querySplateTemplateList(SplateTemplate condition) {
        return splateTemplateBO.querySplateTemplateList(condition);
    }

    @Override
    public SplateTemplate getSplateTemplate(String code) {
        return splateTemplateBO.getSplateTemplate(code);
    }
}
