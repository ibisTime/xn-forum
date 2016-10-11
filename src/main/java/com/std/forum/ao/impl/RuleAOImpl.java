package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IRuleAO;
import com.std.forum.bo.IRuleBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Rule;
import com.std.forum.exception.BizException;

@Service
public class RuleAOImpl implements IRuleAO {

    @Autowired
    private IRuleBO ruleBO;

    @Override
    public String addRule(Rule data) {
        return ruleBO.saveRule(data);
    }

    @Override
    public int editRule(Rule data) {
        if (!ruleBO.isRuleExist(data.getCode())) {
            throw new BizException("xn0000", "规则编号不存在");
        }
        return ruleBO.refreshRule(data);
    }

    @Override
    public int dropRule(String code) {
        if (!ruleBO.isRuleExist(code)) {
            throw new BizException("xn0000", "规则编号不存在");
        }
        return ruleBO.removeRule(code);
    }

    @Override
    public Paginable<Rule> queryRulePage(int start, int limit, Rule condition) {
        return ruleBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Rule> queryRuleList(Rule condition) {
        return ruleBO.queryRuleList(condition);
    }

    @Override
    public Rule getRule(String code) {
        return ruleBO.getRule(code);
    }
}
