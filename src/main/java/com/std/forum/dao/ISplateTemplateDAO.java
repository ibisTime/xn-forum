package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.SplateTemplate;

//dao层 
public interface ISplateTemplateDAO extends IBaseDAO<SplateTemplate> {
    String NAMESPACE = ISplateTemplateDAO.class.getName().concat(".");

    public int update(SplateTemplate data);
}
