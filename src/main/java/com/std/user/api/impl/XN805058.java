package com.std.user.api.impl;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805058Req;
import com.std.user.dto.res.BooleanRes;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 通过登录名发送短信验证码
 * @author: xieyj 
 * @since: 2016年8月16日 下午4:48:18 
 * @history:
 */
public class XN805058 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805058Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doSendLoginPwdSms(req.getLoginName());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805058Req.class);
        StringValidater.validateBlank(req.getLoginName());
    }
}
