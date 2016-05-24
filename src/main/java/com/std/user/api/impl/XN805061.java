package com.std.user.api.impl;

import com.std.user.ao.IBankCardAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805061Req;
import com.std.user.dto.res.XN805061Res;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 删除银行卡
 * @author: myb858 
 * @since: 2016年1月13日 下午2:10:08 
 * @history:
 */
public class XN805061 extends AProcessor {
    private IBankCardAO bankCardAO = SpringContextHolder
        .getBean(IBankCardAO.class);

    private XN805061Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bankCardAO.dropBankCard(req.getCode());
        return new XN805061Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805061Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
