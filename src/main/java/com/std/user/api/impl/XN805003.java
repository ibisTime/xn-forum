package com.std.user.api.impl;

import com.std.user.ao.ISYSMenuAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.domain.SYSMenu;
import com.std.user.dto.req.XN805003Req;
import com.std.user.dto.res.PKCodeRes;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 菜单-增加
 * @author: xieyj 
 * @since: 2016年5月16日 下午10:59:56 
 * @history:
 */
public class XN805003 extends AProcessor {

    private ISYSMenuAO sysMenuAO = SpringContextHolder
        .getBean(ISYSMenuAO.class);

    private XN805003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSMenu data = new SYSMenu();
        data.setName(req.getName());
        data.setType(req.getType());
        data.setUrl(req.getUrl());
        data.setParentCode(req.getParentCode());
        data.setOrderNo(req.getOrderNo());

        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        data.setKind(req.getKind());
        return new PKCodeRes(sysMenuAO.addSYSMenu(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805003Req.class);
        StringValidater.validateBlank(req.getName(), req.getType(),
            req.getUrl(), req.getParentCode(), req.getOrderNo(),
            req.getUpdater(), req.getKind());
    }
}
