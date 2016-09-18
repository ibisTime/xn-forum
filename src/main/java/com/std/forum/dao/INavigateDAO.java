package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Navigate;

/** 
 * 导航DAO
 * @author: zuixian 
 * @since: 2016年9月14日 上午10:46:42 
 * @history:
 */
public interface INavigateDAO extends IBaseDAO<Navigate> {
    String NAMESPACE = INavigateDAO.class.getName().concat(".");

    /** 
     * 更新导航信息
     * @param data
     * @return 
     * @create: 2016年9月14日 上午10:45:43 zuixian
     * @history: 
     */
    public int update(Navigate data);
}
