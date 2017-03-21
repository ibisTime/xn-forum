package com.std.forum.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.forum.ao.IBplateAO;
import com.std.forum.bo.IBplateBO;
import com.std.forum.bo.ISplateBO;
import com.std.forum.bo.ISplateTemplateBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Bplate;
import com.std.forum.domain.Splate;
import com.std.forum.enums.EPlateStatus;
import com.std.forum.exception.BizException;

@Service
public class BplateAOImpl implements IBplateAO {

    @Autowired
    private IBplateBO bplateBO;

    @Autowired
    private ISplateTemplateBO splateTemplateBO;

    @Autowired
    private ISplateBO splateBO;

    @Override
    public String addBplate(String name, String status, String orderNo,
            String companyCode, String updater) {
        return bplateBO.saveBplate(name, status, orderNo, companyCode, updater);
    }

    @Override
    public int editBplate(String code, String name, String status,
            String orderNo, String companyCode, String updater) {
        if (!bplateBO.isBplateExist(code)) {
            throw new BizException("xn0000", "大板块编号不存在");
        }
        return bplateBO.refreshBplate(code, name, status, orderNo, companyCode,
            updater);
    }

    @Override
    @Transactional
    public int dropBplate(String code) {
        Bplate bplate = bplateBO.getBplate(code);
        if (EPlateStatus.UNENABLE.getCode().equals(bplate.getStatus())) {
            throw new BizException("xn0000", "大板块正在使用，不可删除");
        }
        List<Splate> splateList = splateBO.querySplateList(code);
        if (CollectionUtils.isNotEmpty(splateList)) {
            for (Splate splate : splateList) {
                if (EPlateStatus.ENABLE.getCode().equals(splate.getStatus())) {
                    throw new BizException("xn0000", "小板块正在使用，不可删除");
                }
                splateBO.removeSplate(splate.getCode());
            }
        }
        return bplateBO.removeBplate(code);
    }

    @Override
    public Paginable<Bplate> queryBplatePage(int start, int limit,
            Bplate condition) {
        return bplateBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Bplate> queryBplateList(Bplate condition) {
        return bplateBO.queryBplateList(condition);
    }

    @Override
    public Bplate getBplate(String code) {
        return bplateBO.getBplate(code);
    }
}
