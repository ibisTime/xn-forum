package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Category;

/** 
 * @author: haiqingzheng 
 * @since: 2016年11月16日 下午3:49:59 
 * @history:
 */
public interface ICategoryDAO extends IBaseDAO<Category> {
    String NAMESPACE = ICategoryDAO.class.getName().concat(".");

    public int update(Category data);
}
