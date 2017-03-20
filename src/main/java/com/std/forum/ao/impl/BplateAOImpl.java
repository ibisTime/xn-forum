package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IBplateAO;
import com.std.forum.bo.IBplateBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Bplate;
import com.std.forum.exception.BizException;

@Service
public class BplateAOImpl implements IBplateAO {

    @Autowired
    private IBplateBO bplateBO;

    @Override
    public String addBplate(String name, String status, String orderNo,
            String updater) {
        return bplateBO.saveBplate(name, status, orderNo, updater);
    }

    @Override
    public int editBplate(String code, String name, String status,
            String orderNo, String updater) {
        if (!bplateBO.isBplateExist(code)) {
            throw new BizException("xn0000", "大板块编号不存在");
        }
        return bplateBO.refreshBplate(code, name, status, orderNo, updater);
    }

    @Override
    public int dropBplate(String code) {
        if (!bplateBO.isBplateExist(code)) {
            throw new BizException("xn0000", "大板块编号不存在");
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
