package com.std.forum.api.impl;

import com.std.forum.ao.IProdOrderAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610331Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 订单详情
 * @author: xieyj 
 * @since: 2016年10月28日 上午9:59:03 
 * @history:
 */
public class XN610331 extends AProcessor {

    private IProdOrderAO prodOrder = SpringContextHolder
        .getBean(IProdOrderAO.class);

    private XN610331Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return prodOrder.getProdOrder(req.getOrderCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610331Req.class);
        StringValidater.validateBlank(req.getOrderCode());
    }
}
