/**
 * @Title IKeywordDAO.java 
 * @Package com.std.forum.dao 
 * @Description 
 * @author xieyj  
 * @date 2016年8月28日 下午9:34:28 
 * @version V1.0   
 */
package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Keyword;

/** 
 * 站点DAO
 * @author: xieyj 
 * @since: 2016年8月28日 下午9:34:28 
 * @history:
 */
public interface IKeywordDAO extends IBaseDAO<Keyword> {
    String NAMESPACE = IKeywordDAO.class.getName().concat(".");

    /**
     * 更新关键词
     */
    public int update(Keyword data);

}
