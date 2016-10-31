package com.std.forum.api.impl;

import com.std.forum.ao.IProductAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610320Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 兑换商品
 * @author: zuixian 
 * @since: 2016年10月12日 下午2:35:30 
 * @history:
 */
public class XN610320 extends AProcessor {

    private IProductAO productAO = SpringContextHolder
        .getBean(IProductAO.class);

    private XN610320Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return productAO.exchangeProduct(req.getUserId(), req.getProductCode(),
            StringValidater.toInteger(req.getQuantity()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610320Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getProductCode());
        StringValidater.validateNumber(req.getQuantity());
    }
}
