package com.std.forum.api.impl;

import com.std.forum.ao.IPlateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610032Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 详情查询板块信息
 * @author: zuixian 
 * @since: 2016年9月19日 下午1:44:35 
 * @history:
 */
public class XN610032 extends AProcessor {

    private IPlateAO plateAO = SpringContextHolder.getBean(IPlateAO.class);

    private XN610032Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return plateAO.doGetPlate(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610032Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
