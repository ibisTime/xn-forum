package com.std.forum.api.impl;

import com.std.forum.ao.IBplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610022Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 修改大板块
 * @author: asus 
 * @since: 2017年3月20日 下午5:51:10 
 * @history:
 */
public class XN610022 extends AProcessor {
    private IBplateAO bplateAO = SpringContextHolder.getBean(IBplateAO.class);

    private XN610022Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bplateAO.editBplate(req.getCode(), req.getName(), req.getStatus(),
            req.getOrderNo(), req.getCompanyCode(), req.getUpdater());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610022Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getStatus(), req.getOrderNo(), req.getCompanyCode(),
            req.getUpdater());
    }

}
