package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Bplate;

//dao层 
public interface IBplateDAO extends IBaseDAO<Bplate> {
    String NAMESPACE = IBplateDAO.class.getName().concat(".");

    public int update(Bplate data);
}
