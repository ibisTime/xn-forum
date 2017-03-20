/**
 * @Title KeyWordDAOImpl.java 
 * @Package com.std.forum.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午1:16:17 
 * @version V1.0   
 */
package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.IKeywordDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Keyword;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:16:17 
 * @history:
 */
@Repository("keywordDAOImpl")
public class KeywordDAOImpl extends AMybatisTemplate implements IKeywordDAO {

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Keyword data) {
        return super.insert(NAMESPACE.concat("insert_keyword"), data);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Keyword data) {
        return super.delete(NAMESPACE.concat("delete_keyword"), data);

    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Keyword select(Keyword condition) {
        return (Keyword) super.select(NAMESPACE.concat("select_keyword"),
            condition, Keyword.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Keyword condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_keyword_count"),
            condition);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Keyword> selectList(Keyword condition) {
        return super.selectList(NAMESPACE.concat("select_keyword"), condition,
            Keyword.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Keyword> selectList(Keyword condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_keyword"), start,
            count, condition, Keyword.class);
    }

    /** 
     * @see com.std.forum.dao.IKeywordDAO#update(com.std.forum.domain.Keyword)
     */
    @Override
    public int update(Keyword data) {
        return super.update(NAMESPACE.concat("update_keyword"), data);
    }
}
