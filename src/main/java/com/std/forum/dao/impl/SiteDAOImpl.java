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
 * @author: zuixian 
 * @since: 2016年9月13日 下午3:03:38 
 * @history: xieyj 2016年8月28日 下午9:35:51
 */
@Repository("siteDAOImpl")
public class SiteDAOImpl extends AMybatisTemplate implements ISiteDAO {

    @Override
    public int insert(Site data) {
        return super.insert(NAMESPACE.concat("insert_site"), data);
    }

    @Override
    public int delete(Site data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Site select(Site condition) {
        return super.select(NAMESPACE.concat("select_site"), condition,
            Site.class);
    }

    @Override
    public long selectTotalCount(Site condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_site_count"),
            condition);
    }

    @Override
    public List<Site> selectList(Site condition) {
        return super.selectList(NAMESPACE.concat("select_site"), condition,
            Site.class);
    }

    @Override
    public List<Site> selectList(Site condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_site"), start, count,
            condition, Site.class);
    }

    @Override
    public int update(Site data) {
        return super.update("update_site", data);
    }

    @Override
    public int updateDef(Site data) {
        return super.update("update_siteDef", data);
    }

    @Override
    public int updatePri(Site data) {
        return super.update("update_sitePri", data);
    }
}
