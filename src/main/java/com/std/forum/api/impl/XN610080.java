package com.std.forum.api.impl;

import com.std.forum.ao.ICommentAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610080Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 评论详情查询
 * @author: xieyj 
 * @since: 2016年10月13日 下午2:10:14 
 * @history:
 */
public class XN610080 extends AProcessor {

    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN610080Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return commentAO.getComment(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610080Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
