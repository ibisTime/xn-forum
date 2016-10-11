package com.std.forum.api.impl;

import com.std.forum.ao.IRuleAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610121Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 详情查询规则
 * @author: xieyj 
 * @since: 2016年10月11日 上午9:45:51 
 * @history:
 */
public class XN610121 extends AProcessor {
    private IRuleAO ruleAO = SpringContextHolder.getBean(IRuleAO.class);

    private XN610121Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return ruleAO.getRule(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610121Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
