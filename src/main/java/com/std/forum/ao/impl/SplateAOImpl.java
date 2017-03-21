package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.ISplateAO;
import com.std.forum.bo.ISplateBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Splate;
import com.std.forum.dto.req.XN610040Req;
import com.std.forum.dto.req.XN610042Req;
import com.std.forum.enums.EPlateStatus;
import com.std.forum.exception.BizException;

@Service
public class SplateAOImpl implements ISplateAO {

    @Autowired
    private ISplateBO splateBO;

    @Override
    public String addSplate(XN610040Req req) {
        return splateBO.saveSplate(req.getName(), req.getParentCode(),
            req.getPic(), req.getOrderNo(), req.getUserId(),
            req.getCompanyCode(), req.getStatus(), req.getUpdater(),
            req.getRemark());
    }

    @Override
    public int editSplate(XN610042Req req) {
        if (!splateBO.isSplateExist(req.getCode())) {
            throw new BizException("xn0000", "小模板编号不存在");
        }
        return splateBO.refreshSplate(req.getCode(), req.getName(),
            req.getParentCode(), req.getPic(), req.getOrderNo(),
            req.getUserId(), req.getCompanyCode(), req.getStatus(),
            req.getUpdater(), req.getRemark());
    }

    @Override
    public int dropSplate(String code) {
        Splate splate = splateBO.getSplate(code);
        if (EPlateStatus.ENABLE.getCode().equals(splate.getStatus())) {
            throw new BizException("xn0000", "小板块正在被使用，不可以删除");
        }
        return splateBO.removeSplate(code);
    }

    @Override
    public Paginable<Splate> querySplatePage(int start, int limit,
            Splate condition) {
        return splateBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Splate> querySplateList(Splate condition) {
        return splateBO.querySplateList(condition);
    }

    @Override
    public Splate getSplate(String code) {
        return splateBO.getSplate(code);
    }
}
