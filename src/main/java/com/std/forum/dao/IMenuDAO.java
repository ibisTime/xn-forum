package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Menu;

//dao层 
public interface IMenuDAO extends IBaseDAO<Menu> {
    String NAMESPACE = IMenuDAO.class.getName().concat(".");

    public int updateByGlobal(Menu data);

    public int updateByLocal(Menu data);
}
