package com.std.user.api.impl;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805059Req;
import com.std.user.dto.res.XN805057Res;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 管理端找回登录密码
 * @author: xieyj 
 * @since: 2016年8月16日 下午4:48:18 
 * @history:
 */
public class XN805059 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805059Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doFindLoginPwdByOss(req.getLoginName(), req.getSmsCaptcha(),
            req.getNewLoginPwd(), req.getLoginPwdStrength());
        return new XN805057Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805059Req.class);
        StringValidater.validateBlank(req.getLoginName(), req.getSmsCaptcha(),
            req.getNewLoginPwd(), req.getLoginPwdStrength());
    }
}
