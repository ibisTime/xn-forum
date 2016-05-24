package com.std.user.api.impl;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805045Req;
import com.std.user.dto.res.XN805045Res;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 设置交易密码
 * @author: myb858 
 * @since: 2015年8月23日 下午2:19:53 
 * @history:
 */
public class XN805045 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805045Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doSetTradePwd(req.getUserId(), req.getTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha());
        return new XN805045Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805045Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha());
    }

}
