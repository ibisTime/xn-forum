package com.std.forum.api.impl;

import com.std.forum.ao.IBannerAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610106Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 分页查询banner
 * @author: asus 
 * @since: 2017年3月22日 上午9:55:36 
 * @history:
 */
public class XN610106 extends AProcessor {
    private IBannerAO bannerAO = SpringContextHolder.getBean(IBannerAO.class);

    private XN610106Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bannerAO.getBanner(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610106Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
