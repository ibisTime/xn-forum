package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.IRuleDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Rule;

@Repository("ruleDAOImpl")
public class RuleDAOImpl extends AMybatisTemplate implements IRuleDAO {

    @Override
    public int insert(Rule data) {
        return super.insert(NAMESPACE.concat("insert_rule"), data);
    }

    @Override
    public int delete(Rule data) {
        return super.delete(NAMESPACE.concat("delete_rule"), data);
    }

    @Override
    public Rule select(Rule condition) {
        return super.select(NAMESPACE.concat("select_rule"), condition,
            Rule.class);
    }

    @Override
    public long selectTotalCount(Rule condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_rule_count"),
            condition);
    }

    @Override
    public List<Rule> selectList(Rule condition) {
        return super.selectList(NAMESPACE.concat("select_rule"), condition,
            Rule.class);
    }

    @Override
    public List<Rule> selectList(Rule condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_rule"), start, count,
            condition, Rule.class);
    }

    /** 
     * @see com.std.forum.dao.IRuleDAO#update(com.std.forum.domain.Plate)
     */
    @Override
    public int update(Rule data) {
        return super.update(NAMESPACE.concat("update_rule"), data);
    }
}
