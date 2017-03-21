package com.std.forum.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.ISubsystemAO;
import com.std.forum.bo.ISubsystemBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Subsystem;
import com.std.forum.dto.req.XN610090Req;
import com.std.forum.dto.req.XN610091Req;
import com.std.forum.enums.EBelong;
import com.std.forum.enums.EBoolean;
import com.std.forum.exception.BizException;

@Service
public class SubsystemAOImpl implements ISubsystemAO {

    @Autowired
    private ISubsystemBO subsystemBO;

    @Override
    public void editSubsystemByGlobal(XN610090Req req) {
        Subsystem subsystem = subsystemBO.getSubsystem(req.getCode());
        if (EBelong.GLOBAL.getCode().equals(subsystem.getBelong())
                || EBelong.LOCAL.getCode().equals(subsystem.getBelong())) {
            subsystemBO.refreshSubsystem(req.getCode(), req.getName(),
                req.getUrl(), req.getPic(), req.getLocation(),
                req.getOrderNo(), req.getCompanyCode(), req.getRemark());
        } else {
            throw new BizException("xn0000", "地方性菜单，不可修改");
        }
    }

    @Override
    public void editSubsystemByLocal(XN610091Req req) {
        Subsystem subsystem = subsystemBO.getSubsystem(req.getCode());
        if (EBelong.LOCAL.getCode().equals(subsystem.getBelong())) {
            subsystemBO.saveSubsystem(req.getName(), req.getUrl(),
                req.getPic(), req.getLocation(), req.getOrderNo(),
                req.getCompanyCode(), req.getRemark());
        } else if (EBelong.GLOBAL.getCode().equals(subsystem.getBelong())) {
            throw new BizException("xn0000", "总部子系统，地方不可修改");
        } else {//
            subsystemBO.refreshSubsystem(req.getCode(), req.getName(),
                req.getUrl(), req.getPic(), req.getLocation(),
                req.getOrderNo(), req.getCompanyCode(), req.getRemark());
        }
    }

    @Override
    public Paginable<Subsystem> querySubsystemPage(int start, int limit,
            Subsystem condition) {
        return subsystemBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Subsystem> querySubsystemList(String companyCode) {
        List<Subsystem> resultSubsystem = new ArrayList<Subsystem>();
        List<Subsystem> localList = subsystemBO.querySubsystemList(companyCode);
        List<Subsystem> globalList = subsystemBO.querySubsystemList(EBoolean.NO
            .getCode());
        return resultSubsystem;
    }

    @Override
    public Subsystem getSubsystem(String code) {
        return subsystemBO.getSubsystem(code);
    }

}
