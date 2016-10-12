package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.PostConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Post;
import com.std.forum.dto.req.XN610053Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 设置帖子属性
 * @author: zuixian 
 * @since: 2016年9月19日 下午4:45:09 
 * @history:
 */
public class XN610053 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610053Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Post data = PostConverter.converter(req);
        return new BooleanRes(postAO.setUpPost(data) > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610053Req.class);
        StringValidater.validateBlank(req.getCode(), req.getLocation());
    }
}
