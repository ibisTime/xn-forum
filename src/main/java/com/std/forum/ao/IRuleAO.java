package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Rule;

public interface IRuleAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addRule(Rule data);

    public int dropRule(String code);

    public int editRule(Rule data);

    public Paginable<Rule> queryRulePage(int start, int limit, Rule condition);

    public List<Rule> queryRuleList(Rule condition);

    public Rule getRule(String code);

}
