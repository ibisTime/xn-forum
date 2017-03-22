package com.std.forum.api.impl;

import com.std.forum.ao.IBannerAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610107Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 前端列表查询banner
 * @author: asus 
 * @since: 2017年3月22日 上午10:31:10 
 * @history:
 */
public class XN610107 extends AProcessor {
    private IBannerAO bannerAO = SpringContextHolder.getBean(IBannerAO.class);

    private XN610107Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bannerAO.queryBannerList(req.getCompanyCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610107Req.class);
        StringValidater.validateBlank(req.getCompanyCode());
    }
}
