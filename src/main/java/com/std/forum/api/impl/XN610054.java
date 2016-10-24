package com.std.forum.api.impl;

import com.std.forum.ao.IPostTalkAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610054Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 觉得该帖子写得好，通过资金奖励作者
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:51:38 
 * @history:
 */
public class XN610054 extends AProcessor {

    private IPostTalkAO postTalkAO = SpringContextHolder
        .getBean(IPostTalkAO.class);

    private XN610054Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long amount = StringValidater.toLong(req.getAmount());
        postTalkAO.doPostTalk(req.getPostCode(), req.getTalker(), amount);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610054Req.class);
        StringValidater.validateBlank(req.getPostCode(), req.getTalker());
        StringValidater.validateAmount(req.getAmount());
    }
}
