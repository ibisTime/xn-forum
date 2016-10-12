package com.std.forum.api.impl;

import com.std.forum.ao.IProdOrderAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.ProductConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.ProdOrder;
import com.std.forum.dto.req.XN610320Req;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 通过积分兑换相应的商品
 * @author: zuixian 
 * @since: 2016年10月12日 下午2:35:30 
 * @history:
 */
public class XN610320 extends AProcessor {

    private IProdOrderAO prodOrderAO = SpringContextHolder
        .getBean(IProdOrderAO.class);

    private XN610320Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ProdOrder data = ProductConverter.converter(req);
        String code = prodOrderAO.addProdOrder(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610320Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getProductCode(),
            req.getQuantity());
    }
}
