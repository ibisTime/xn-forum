package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.ICategoryDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Category;

/** 
 * @author: haiqingzheng 
 * @since: 2016年11月16日 下午3:56:04 
 * @history:
 */
@Repository("categoryDAOImpl")
public class CategoryDAOImpl extends AMybatisTemplate implements ICategoryDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Category data) {
        return super.insert(NAMESPACE.concat("insert_category"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Category data) {
        return super.delete(NAMESPACE.concat("delete_category"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Category select(Category condition) {
        return super.select(NAMESPACE.concat("select_category"), condition,
            Category.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Category condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_category_count"), condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Category> selectList(Category condition) {
        return super.selectList(NAMESPACE.concat("select_category"), condition,
            Category.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Category> selectList(Category condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_category"), start,
            count, condition, Category.class);
    }

    /** 
     * @see com.xnjr.mall.dao.ICategoryDAO#updateByGlobal(com.xnjr.mall.domain.Category)
     */
    @Override
    public int update(Category data) {
        return super.update(NAMESPACE.concat("update_category"), data);
    }

}
