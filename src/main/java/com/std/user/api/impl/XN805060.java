package com.std.user.api.impl;

import com.std.user.ao.IBankCardAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805060Req;
import com.std.user.dto.res.XN805060Res;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 绑定银行卡（多卡）
 * @author: myb858 
 * @since: 2015年8月23日 下午2:36:52 
 * @history:
 */
public class XN805060 extends AProcessor {
    private IBankCardAO bankCardAO = SpringContextHolder
        .getBean(IBankCardAO.class);

    private XN805060Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = bankCardAO.doBindBandCard(req.getUserId(),
            req.getBankCode(), req.getBankName(), req.getSubbranch(),
            req.getBankCardNo(), req.getBindMobile(), req.getUpdater(),
            req.getRemark());
        return new XN805060Res(code);

    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805060Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getBankCardNo(),
            req.getUpdater());
    }

}
