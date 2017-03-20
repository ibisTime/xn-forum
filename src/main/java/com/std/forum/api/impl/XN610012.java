package com.std.forum.api.impl;

import com.std.forum.ao.IBplateTemplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610012Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

public class XN610012 extends AProcessor {
    private IBplateTemplateAO bplateTemplateAO = SpringContextHolder
        .getBean(IBplateTemplateAO.class);

    private XN610012Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bplateTemplateAO.editBplateTemplate(req.getCode(), req.getName(),
            req.getOrderNo(), req.getUpdater());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610012Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getOrderNo(), req.getUpdater());
    }

}
