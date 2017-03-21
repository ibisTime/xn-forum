package com.std.forum.api.impl;

import com.std.forum.ao.IBannerAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610100Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 总部修改banner 
 * @author: asus 
 * @since: 2017年3月21日 下午8:09:10 
 * @history:
 */
public class XN610100 extends AProcessor {
    private IBannerAO bannerAO = SpringContextHolder.getBean(IBannerAO.class);

    private XN610100Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bannerAO.editBannerGlobal(req.getCode(), req.getName(), req.getUrl(),
            req.getPic(), req.getLocation(), req.getOrderNo(), req.getBelong(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610100Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getUrl(), req.getPic(), req.getLocation(), req.getOrderNo(),
            req.getBelong());
    }
}
