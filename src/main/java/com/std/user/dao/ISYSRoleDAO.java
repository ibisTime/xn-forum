package com.std.user.dao;

import com.std.user.dao.base.IBaseDAO;
import com.std.user.domain.SYSRole;

public interface ISYSRoleDAO extends IBaseDAO<SYSRole> {
    String NAMESPACE = ISYSRoleDAO.class.getName().concat(".");

    public int update(SYSRole data);
}
