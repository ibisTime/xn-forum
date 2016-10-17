package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610060Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 每查看帖子一次，增加一次阅读量，针对用户
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:51:54 
 * @history:
 */
public class XN610060 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610060Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        postAO.readPost(req.getPostCode(), req.getUserId());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610060Req.class);
        StringValidater.validateBlank(req.getPostCode(), req.getUserId());
    }
}
