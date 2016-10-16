package com.std.forum.api.impl;

import com.std.forum.ao.IUserAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610903Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 每日签到
 * @author: xieyj 
 * @since: 2016年10月12日 上午5:28:37 
 * @history:
 */
public class XN610903 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN610903Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doSignToday(req.getUserId(), req.getLocation());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610903Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}
