package com.std.forum.api.impl;

import com.std.forum.ao.IPostTalkAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.PostTalkConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.PostTalk;
import com.std.forum.dto.req.XN610059Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

public class XN610059 extends AProcessor {

    private IPostTalkAO postTalkAO = SpringContextHolder
        .getBean(IPostTalkAO.class);

    private XN610059Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        PostTalk data = PostTalkConverter.converter(req);
        return new BooleanRes(postTalkAO.doPostTalkByAmount(data) > 0 ? true
                : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610059Req.class);
        StringValidater.validateBlank(req.getPostCode(), req.getAmount(),
            req.getTalker());
    }
}
