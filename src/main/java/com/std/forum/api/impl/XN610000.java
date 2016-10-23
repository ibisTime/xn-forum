package com.std.forum.api.impl;

import com.std.forum.ao.IKeywordAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.KeywordConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Keyword;
import com.std.forum.dto.req.XN610000Req;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 新增关键词
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:53:13 
 * @history:
 */
public class XN610000 extends AProcessor {

    private IKeywordAO keywordAO = SpringContextHolder
        .getBean(IKeywordAO.class);

    private XN610000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Keyword data = KeywordConverter.converter(req);
        return new PKCodeRes(keywordAO.addKeyword(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610000Req.class);
        StringValidater.validateBlank(req.getWord(), req.getLevel(),
            req.getWeight(), req.getReaction(), req.getUpdater());
    }
}
