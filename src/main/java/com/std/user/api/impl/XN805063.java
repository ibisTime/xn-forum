package com.std.user.api.impl;

import com.std.user.ao.IBankCardAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805063Req;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 获取当前用户个人银行以及公司银行卡列表
 * @author: myb858 
 * @since: 2016年1月27日 下午4:42:53 
 * @history:
 */
public class XN805063 extends AProcessor {
    private IBankCardAO bankCardAO = SpringContextHolder
        .getBean(IBankCardAO.class);

    private XN805063Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bankCardAO.queryBankCardList(req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805063Req.class);
        StringValidater.validateBlank(req.getUserId());

    }

}
