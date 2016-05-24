package com.std.user.api.impl;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805050Req;
import com.std.user.dto.res.XN805050Res;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 *找回交易密码
 * @author: myb858 
 * @since: 2015年9月15日 下午2:14:13 
 * @history:
 */
public class XN805050 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doFindTradePwd(req.getUserId(), req.getNewTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha(), req.getIdKind(),
            req.getIdNo());
        return new XN805050Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805050Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getNewTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha(), req.getIdKind(),
            req.getIdNo());

    }

}
