package com.std.forum.api.impl;

import com.std.forum.ao.IKeywordAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610006Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 详情查询关键字
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:54:03 
 * @history:
 */
public class XN610006 extends AProcessor {

    private IKeywordAO keywordAO = SpringContextHolder
        .getBean(IKeywordAO.class);

    private XN610006Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return keywordAO.getKeyword(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610006Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
