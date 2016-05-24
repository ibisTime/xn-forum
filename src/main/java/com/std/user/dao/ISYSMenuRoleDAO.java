package com.std.user.dao;

import java.util.List;

import com.std.user.dao.base.IBaseDAO;
import com.std.user.domain.SYSMenu;
import com.std.user.domain.SYSMenuRole;

/**
 * 角色菜单
 * @author: Gejin 
 * @since: 2016年4月16日 下午10:24:53 
 * @history:
 */
public interface ISYSMenuRoleDAO extends IBaseDAO<SYSMenuRole> {
    String NAMESPACE = ISYSMenuRoleDAO.class.getName().concat(".");

    public List<SYSMenu> selectSYSMenuList(SYSMenuRole data);

    public int deleteSYSMenuList(SYSMenuRole data);
}
