package com.std.user.api.impl;

import com.std.user.ao.ISYSMenuAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.domain.SYSMenu;
import com.std.user.dto.req.XN805005Req;
import com.std.user.dto.res.BooleanRes;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 菜单-修改
 * @author: xieyj 
 * @since: 2016年5月16日 下午9:46:32 
 * @history:
 */
public class XN805005 extends AProcessor {
    private ISYSMenuAO sysMenuAO = SpringContextHolder
        .getBean(ISYSMenuAO.class);

    private XN805005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSMenu condition = new SYSMenu();
        condition.setCode(req.getCode());

        condition.setName(req.getName());
        condition.setType(req.getType());
        condition.setUrl(req.getUrl());
        condition.setParentCode(req.getParentCode());
        condition.setOrderNo(req.getOrderNo());

        condition.setUpdater(req.getUpdater());
        condition.setRemark(req.getRemark());
        condition.setKind(req.getKind());
        return new BooleanRes(sysMenuAO.editSYSMenu(condition));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805005Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getType(), req.getUrl(), req.getParentCode(), req.getOrderNo(),
            req.getUpdater(), req.getKind());
    }
}
