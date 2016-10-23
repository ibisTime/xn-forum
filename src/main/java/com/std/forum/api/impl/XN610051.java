package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610051Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 锁帖/取消锁帖
 * @author: xieyj 
 * @since: 2016年10月23日 下午9:12:51 
 * @history:
 */
public class XN610051 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610051Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        postAO.setPostLock(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610051Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
