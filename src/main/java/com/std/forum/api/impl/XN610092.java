package com.std.forum.api.impl;

import com.std.forum.ao.IKeywordAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.KeywordConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Keyword;
import com.std.forum.dto.req.XN610092Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 修改关键词
 * @author: xieyj 
 * @since: 2016年10月10日 下午11:46:09 
 * @history:
 */
public class XN610092 extends AProcessor {

    private IKeywordAO keywordAO = SpringContextHolder
        .getBean(IKeywordAO.class);

    private XN610092Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Keyword data = KeywordConverter.converter(req);
        keywordAO.editKeyword(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610092Req.class);
        StringValidater.validateBlank(req.getCode(), req.getWord(),
            req.getLevel(), req.getWeight(), req.getReaction(),
            req.getUpdater());
    }
}
