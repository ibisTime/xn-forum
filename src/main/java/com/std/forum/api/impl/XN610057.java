package com.std.forum.api.impl;

import com.std.forum.ao.ICommentAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Comment;
import com.std.forum.dto.req.XN610057Req;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

public class XN610057 extends AProcessor {

    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN610057Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Comment data = new Comment();
        data.setContent(req.getContent());
        data.setParentCode(req.getParentCode());
        data.setCommer(req.getCommer());
        return new PKCodeRes(commentAO.doComment(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610057Req.class);
        StringValidater.validateBlank(req.getContent(), req.getParentCode(),
            req.getCommer());
    }
}
