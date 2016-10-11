package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Rule;

public interface IRuleDAO extends IBaseDAO<Rule> {
    String NAMESPACE = IRuleDAO.class.getName().concat(".");

    /**
     * 更新规则
     */
    public int update(Rule data);
}
