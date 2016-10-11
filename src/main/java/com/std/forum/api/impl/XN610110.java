package com.std.forum.api.impl;

import com.std.forum.ao.IRuleAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.RuleConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Rule;
import com.std.forum.dto.req.XN610110Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 修改规则
 * @author: xieyj 
 * @since: 2016年10月10日 下午11:46:09 
 * @history:
 */
public class XN610110 extends AProcessor {

    private IRuleAO ruleAO = SpringContextHolder.getBean(IRuleAO.class);

    private XN610110Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Rule data = RuleConverter.converter(req);
        ruleAO.editRule(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610110Req.class);
        StringValidater.validateBlank(req.getCode(), req.getKind(),
            req.getValue(), req.getUpdater());
    }
}
