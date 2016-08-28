/**
 * @Title SiteDAOImpl.java 
 * @Package com.std.forum.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月28日 下午9:35:51 
 * @version V1.0   
 */
package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.ISiteDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Site;

/** 
 * @author: xieyj 
 * @since: 2016年8月28日 下午9:35:51 
 * @history:
 */
@Repository("siteDAOImpl")
public class SiteDAOImpl extends AMybatisTemplate implements ISiteDAO {

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Site data) {
        return super.insert(NAMESPACE.concat("insert_site"), data);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Site data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Site select(Site condition) {
        return (Site) super.select(NAMESPACE.concat("select_site"), condition,
            Site.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public long selectTotalCount(Site condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_site_count"),
            condition);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Site> selectList(Site condition) {
        return super.selectList(NAMESPACE.concat("select_site"), condition,
            Site.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Site> selectList(Site condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_site"), start, count,
            condition, Site.class);
    }

    /** 
     * @see com.std.forum.dao.ISiteDAO#update(com.std.forum.domain.Site)
     */
    @Override
    public int update(Site data) {
        return super.update(NAMESPACE.concat("update_site"), data);
    }
}
