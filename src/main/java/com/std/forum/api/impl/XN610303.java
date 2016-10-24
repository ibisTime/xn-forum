package com.std.forum.api.impl;

import com.std.forum.ao.IProductAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610303Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 上下架产品
 * @author: zuixian 
 * @since: 2016年10月12日 上午11:04:33 
 * @history:
 */
public class XN610303 extends AProcessor {
    private IProductAO productAO = SpringContextHolder
        .getBean(IProductAO.class);

    private XN610303Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        productAO.editProductStatus(req.getCode(),
            StringValidater.toLong(req.getPrice()));
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610303Req.class);
        StringValidater.validateBlank(req.getCode(), req.getPrice());
    }
}
