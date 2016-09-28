package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.PostConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.domain.Post;
import com.std.forum.dto.req.XN610071Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 列表查询帖子
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:52:13 
 * @history:
 */
public class XN610071 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610071Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Post condition = PostConverter.converter(req);
        return postAO.queryPostList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610071Req.class);
    }
}
