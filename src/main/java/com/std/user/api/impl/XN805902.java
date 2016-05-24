package com.std.user.api.impl;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805902Req;
import com.std.user.dto.res.XN805902Res;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 交易密码正确性与否
 * @author: myb858 
 * @since: 2015年11月1日 下午3:45:58 
 * @history:
 */
public class XN805902 extends AProcessor {

    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805902Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.checkTradePwd(req.getUserId(), req.getTradePwd());
        return new XN805902Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805902Req.class);
        StringValidater.validateBlank(req.getTokenId(), req.getUserId(),
            req.getTradePwd());

    }

}
