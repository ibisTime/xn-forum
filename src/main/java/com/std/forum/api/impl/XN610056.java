package com.std.forum.api.impl;

import com.std.forum.ao.IPostTalkAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.PostTalkConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.PostTalk;
import com.std.forum.dto.req.XN610056Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 给自己喜欢的帖子点赞，收藏，取消已点赞，收藏的帖子
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:50:37 
 * @history:
 */
public class XN610056 extends AProcessor {

    private IPostTalkAO postTalkAO = SpringContextHolder
        .getBean(IPostTalkAO.class);

    private XN610056Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        PostTalk data = PostTalkConverter.converter(req);
        return new BooleanRes(postTalkAO.doPostTalk(data) > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610056Req.class);
        StringValidater.validateBlank(req.getType(), req.getPostCode(),
            req.getTalker());
    }
}
