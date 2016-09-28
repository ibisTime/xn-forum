package com.std.forum.api.impl;

import com.std.forum.ao.IKeywordAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610092Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 删除关键词
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:53:37 
 * @history:
 */
public class XN610092 extends AProcessor {

    private IKeywordAO keywordAO = SpringContextHolder
        .getBean(IKeywordAO.class);

    private XN610092Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        int count = keywordAO.dropKeyword(req.getCode());
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610092Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
