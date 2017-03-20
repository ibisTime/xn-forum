package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.BplateTemplate;

//Idao层 
public interface IBplateTemplateDAO extends IBaseDAO<BplateTemplate> {
    String NAMESPACE = IBplateTemplateDAO.class.getName().concat(".");

    public int update(BplateTemplate data);
}
