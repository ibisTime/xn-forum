package com.std.user.api.impl;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805049Req;
import com.std.user.dto.res.XN805049Res;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 重置登录密码
 * @author: myb858 
 * @since: 2015年9月15日 下午2:13:26 
 * @history:
 */
public class XN805049 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805049Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doResetLoginPwd(req.getUserId(), req.getOldLoginPwd(),
            req.getNewLoginPwd(), req.getLoginPwdStrength());
        return new XN805049Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805049Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getOldLoginPwd(),
            req.getNewLoginPwd());

    }

}
