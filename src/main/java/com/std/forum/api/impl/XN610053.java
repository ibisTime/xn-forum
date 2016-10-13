package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610053Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 设置帖子置顶和精华
 * @author: xieyj 
 * @since: 2016年10月13日 下午1:02:45 
 * @history:
 */
public class XN610053 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610053Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        postAO.setPostLocation(req.getCode(), req.getLocation(),
            req.getOrderNo());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610053Req.class);
        StringValidater.validateBlank(req.getCode(), req.getLocation());
    }
}
