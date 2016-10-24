package com.std.forum.api.impl;

import com.std.forum.ao.IProductAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.ProductConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Product;
import com.std.forum.dto.req.XN610302Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 修改产品信息
 * @author: zuixian 
 * @since: 2016年10月12日 上午11:04:33 
 * @history:
 */
public class XN610302 extends AProcessor {
    private IProductAO productAO = SpringContextHolder
        .getBean(IProductAO.class);

    private XN610302Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Product data = ProductConverter.converter(req);
        productAO.editProduct(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610302Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getKind(), req.getPic(), req.getDescription(),
            req.getSiteCode());
        StringValidater.validateNumber(req.getQuantity());
    }
}
