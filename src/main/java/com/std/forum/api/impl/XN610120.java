package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.IRuleAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.RuleConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Rule;
import com.std.forum.dto.req.XN610120Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 分页查询规则
 * @author: xieyj 
 * @since: 2016年10月11日 上午9:44:16 
 * @history:
 */
public class XN610120 extends AProcessor {

    private IRuleAO ruleAO = SpringContextHolder.getBean(IRuleAO.class);

    private XN610120Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Rule condition = RuleConverter.converter(req);
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IRuleAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return ruleAO.queryRulePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610120Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}
