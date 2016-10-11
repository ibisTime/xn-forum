package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Rule;

public interface IRuleBO extends IPaginableBO<Rule> {

    public boolean isRuleExist(String code);

    public String saveRule(Rule data);

    public int removeRule(String code);

    public int refreshRule(Rule data);

    public List<Rule> queryRuleList(Rule condition);

    public Rule getRule(String code);

}
