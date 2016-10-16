package com.std.forum.api.impl;

import com.std.forum.ao.IUserAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.common.PhoneUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN805076Req;
import com.std.forum.dto.res.XN805076Res;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 前端用户注册
 * @author: xieyj 
 * @since: 2016年10月12日 上午5:28:37 
 * @history:
 */
public class XN610900 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805076Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XN805076Res(userAO.doRegister(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805076Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getLoginPwd(),
            req.getLoginPwdStrength(), req.getSmsCaptcha());
        PhoneUtil.checkMobile(req.getMobile());// 判断格式
    }
}
