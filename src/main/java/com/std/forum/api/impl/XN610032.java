package com.std.forum.api.impl;

import com.std.forum.ao.INavigateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610032Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 详情查询导航信息
 * @author: zuixian 
 * @since: 2016年9月14日 下午5:07:59 
 * @history:
 */
public class XN610032 extends AProcessor {

    private INavigateAO navigateAO = SpringContextHolder
        .getBean(INavigateAO.class);

    private XN610032Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return navigateAO.getNavigate(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610032Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
