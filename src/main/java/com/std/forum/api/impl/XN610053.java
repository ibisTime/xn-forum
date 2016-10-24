package com.std.forum.api.impl;

import com.std.forum.ao.IPostTalkAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610053Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 点赞/收藏，或取消点赞/收藏帖子
 * @author: xieyj 
 * @since: 2016年10月23日 下午9:21:09 
 * @history:
 */
public class XN610053 extends AProcessor {

    private IPostTalkAO postTalkAO = SpringContextHolder
        .getBean(IPostTalkAO.class);

    private XN610053Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        postTalkAO
            .doPostTalk(req.getPostCode(), req.getTalker(), req.getType());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610053Req.class);
        StringValidater.validateBlank(req.getType(), req.getPostCode(),
            req.getTalker());
    }
}
