package com.std.forum.api.impl;

import com.std.forum.ao.IKeywordAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610001Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 删除关键词
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:53:20 
 * @history:
 */
public class XN610001 extends AProcessor {

    private IKeywordAO keywordAO = SpringContextHolder
        .getBean(IKeywordAO.class);

    private XN610001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        keywordAO.dropKeyword(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610001Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
