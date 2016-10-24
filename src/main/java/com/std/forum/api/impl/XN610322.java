package com.std.forum.api.impl;

import com.std.forum.ao.IProdOrderAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610322Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 作废
 * @author: zuixian 
 * @since: 2016年10月12日 下午2:35:40 
 * @history:
 */
public class XN610322 extends AProcessor {

    private IProdOrderAO prodOrderAO = SpringContextHolder
        .getBean(IProdOrderAO.class);

    private XN610322Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        prodOrderAO.takeNo(req.getOrderCode(), req.getTakeNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610322Req.class);
        StringValidater.validateBlank(req.getOrderCode(), req.getTakeNote());
    }
}
