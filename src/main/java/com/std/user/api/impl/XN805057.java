package com.std.user.api.impl;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805057Req;
import com.std.user.dto.res.XN805057Res;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 *找回交易密码(无需实名认证)
 * @author: myb858 
 * @since: 2015年9月15日 下午2:14:13 
 * @history:
 */
public class XN805057 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805057Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doFindTradePwd(req.getUserId(), req.getNewTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha());
        return new XN805057Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805057Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getNewTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha());

    }

}
