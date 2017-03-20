package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Splate;

//dao层 
public interface ISplateDAO extends IBaseDAO<Splate> {
    String NAMESPACE = ISplateDAO.class.getName().concat(".");

    public int update(Splate data);
}
