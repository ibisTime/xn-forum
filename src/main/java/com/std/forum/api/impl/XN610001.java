package com.std.forum.api.impl;

import com.std.forum.ao.ISiteAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610001Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 禁用站点
 * @author: zuixian 
 * @since: 2016年9月13日 下午4:25:14 
 * @history:
 */
public class XN610001 extends AProcessor {

    private ISiteAO siteAO = SpringContextHolder.getBean(ISiteAO.class);

    private XN610001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new BooleanRes(siteAO.editSitePri(req.getCode()) > 0 ? true
                : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610001Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
