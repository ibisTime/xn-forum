package com.std.user.dao;

import com.std.user.dao.base.IBaseDAO;
import com.std.user.domain.SYSMenu;

/**
 * @author: Gejin 
 * @since: 2016年4月16日 下午6:54:55 
 * @history:
 */
public interface ISYSMenuDAO extends IBaseDAO<SYSMenu> {
    String NAMESPACE = ISYSMenuDAO.class.getName().concat(".");

    public int update(SYSMenu data);
}
