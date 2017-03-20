package com.std.forum.api.impl;

import com.std.forum.ao.ISplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610041Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

public class XN610041 extends AProcessor {
    private ISplateAO splateAO = SpringContextHolder.getBean(ISplateAO.class);

    private XN610041Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        splateAO.dropSplate(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610041Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
