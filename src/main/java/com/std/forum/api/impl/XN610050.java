package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.PostConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Post;
import com.std.forum.dto.req.XN610050Req;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 发布帖子
 * @author: zuixian 
 * @since: 2016年9月19日 下午4:44:22 
 * @history:
 */
public class XN610050 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Post data = PostConverter.converter(req);
        return new PKCodeRes(postAO.publishPost(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610050Req.class);
        StringValidater.validateBlank(req.getTitle(), req.getContent(),
            req.getPlateCode(), req.getPublisher());
    }
}
