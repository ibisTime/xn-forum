package com.std.user.api.impl;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805048Req;
import com.std.user.dto.res.XN805048Res;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 找回登录密码
 * @author: myb858 
 * @since: 2015年9月15日 下午2:11:01 
 * @history:
 */
public class XN805048 extends AProcessor {

    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805048Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doFindLoginPwd(req.getMobile(), req.getSmsCaptcha(),
            req.getNewLoginPwd(), req.getLoginPwdStrength());
        return new XN805048Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805048Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getSmsCaptcha(),
            req.getNewLoginPwd(), req.getLoginPwdStrength());

    }

}
