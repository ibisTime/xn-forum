/**
 * @Title ISiteDAO.java 
 * @Package com.std.forum.dao 
 * @Description 
 * @author xieyj  
 * @date 2016年8月28日 下午9:34:28 
 * @version V1.0   
 */
package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Site;

/** 
 * 站点DAO
 * @author: xieyj 
 * @since: 2016年8月28日 下午9:34:28 
 * @history:
 */
public interface ISiteDAO extends IBaseDAO<Site> {
    String NAMESPACE = ISiteDAO.class.getName().concat(".");

    /**
     * 更新站点
     */
    public int update(Site data);

    /** 
     * 更新站点是否默认
     * @param data
     * @return 
     * @create: 2016年9月13日 下午3:02:08 zuixian
     * @history: 
     */
    public int updateDef(Site data);

    /** 
     * 禁用站点
     * @param data
     * @return 
     * @create: 2016年9月13日 下午2:57:13 zuixian
     * @history: 
     */
    public int updatePri(Site data);

}
