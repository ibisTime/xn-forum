package com.std.user.api.impl;

import com.std.user.ao.ISYSRoleAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.domain.SYSRole;
import com.std.user.dto.req.XN805023Req;
import com.std.user.dto.res.PKCodeRes;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 角色-新增
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:25:15 
 * @history:
 */
public class XN805023 extends AProcessor {
    private ISYSRoleAO sysRoleAO = SpringContextHolder
        .getBean(ISYSRoleAO.class);

    private XN805023Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSRole data = new SYSRole();
        data.setName(req.getName());
        data.setLevel(req.getLevel());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        data.setKind(req.getKind());
        return new PKCodeRes(sysRoleAO.addSYSRole(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805023Req.class);
        StringValidater.validateBlank(req.getName(), req.getLevel(),
            req.getUpdater(), req.getKind());
    }

}
