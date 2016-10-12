package com.std.forum.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IRuleBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IRuleDAO;
import com.std.forum.domain.Rule;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.enums.ERuleKind;
import com.std.forum.enums.ERuleType;
import com.std.forum.exception.BizException;

@Component
public class RuleBOImpl extends PaginableBOImpl<Rule> implements IRuleBO {

    @Autowired
    private IRuleDAO ruleDAO;

    @Override
    public boolean isRuleExist(String code) {
        Rule condition = new Rule();
        condition.setCode(code);
        if (ruleDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveRule(Rule data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EPrefixCode.RULE.getCode());
            data.setCode(code);
            data.setUpdateDatetime(new Date());
            ruleDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeRule(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Rule data = new Rule();
            data.setCode(code);
            count = ruleDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshRule(Rule data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            data.setUpdateDatetime(new Date());
            count = ruleDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Rule> queryRuleList(Rule condition) {
        return ruleDAO.selectList(condition);
    }

    @Override
    public Rule getRule(String code) {
        Rule data = null;
        if (StringUtils.isNotBlank(code)) {
            Rule condition = new Rule();
            condition.setCode(code);
            data = ruleDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "规则编号不存在");
            }
        }
        return data;
    }

    /** 
     * @see com.std.forum.bo.IRuleBO#getRuleByCondition(java.lang.String, java.lang.String)
     */
    @Override
    public Long getRuleByCondition(ERuleKind kind, ERuleType type) {
        Long amount = 0L;
        // 获取注册送积分数量
        Rule condition = new Rule();
        condition.setKind(kind.getCode());
        condition.setType(type.getCode());
        List<Rule> ruleList = ruleDAO.selectList(condition);
        if (!CollectionUtils.sizeIsEmpty(ruleList)) {
            Rule rule = ruleList.get(0);
            amount = Long.valueOf(rule.getValue());
        }
        return amount;
    }
}
