package com.std.forum.api.impl;

import com.std.forum.ao.IProductAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610311Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 详情查询产品
 * @author: zuixian 
 * @since: 2016年10月12日 下午2:35:20 
 * @history:
 */
public class XN610311 extends AProcessor {

    private IProductAO productAO = SpringContextHolder
        .getBean(IProductAO.class);

    private XN610311Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return productAO.getProduct(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610311Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
