package com.std.forum.api.impl;

import com.std.forum.ao.ISubsystemAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610090Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 总部修改子系统
 * @author: asus 
 * @since: 2017年3月21日 下午5:58:47 
 * @history:
 */
public class XN610090 extends AProcessor {
    private ISubsystemAO subsystemAO = SpringContextHolder
        .getBean(ISubsystemAO.class);

    private XN610090Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        subsystemAO.editSubsystemByGlobal(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610090Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getPic(), req.getLocation(), req.getOrderNo(), req.getBelong());
    }

}
