package com.std.forum.api.impl;

import com.std.forum.ao.IBplateTemplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610010Req;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

public class XN610010 extends AProcessor {
    private IBplateTemplateAO bplateTemplateAO = SpringContextHolder
        .getBean(IBplateTemplateAO.class);

    private XN610010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(bplateTemplateAO.addBplateTemplate(req.getName(),
            req.getOrderNo(), req.getUpdater()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610010Req.class);
        StringValidater.validateBlank(req.getName(), req.getOrderNo(),
            req.getUpdater());
    }

}
