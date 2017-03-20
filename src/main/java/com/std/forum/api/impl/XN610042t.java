package com.std.forum.api.impl;

import com.std.forum.ao.ICommentAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610042Reqt;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 对帖子或评论进行评论
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:50:59 
 * @history:
 */
public class XN610042t extends AProcessor {

    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN610042Reqt req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(commentAO.doComment(req.getContent(),
            req.getParentCode(), req.getCommer()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610042Reqt.class);
        StringValidater.validateBlank(req.getContent(), req.getParentCode(),
            req.getCommer());
    }
}
