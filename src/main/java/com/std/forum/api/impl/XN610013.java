package com.std.forum.api.impl;

import com.std.forum.ao.ISiteAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610013Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 详情查询站点信息
 * @author: zuixian 
 * @since: 2016年9月14日 下午5:09:54 
 * @history:
 */
public class XN610013 extends AProcessor {

    private ISiteAO siteAO = SpringContextHolder.getBean(ISiteAO.class);

    private XN610013Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return siteAO.getSite(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610013Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
