package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.INavigateDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Navigate;

/** 
 * @author: zuixian 
 * @since: 2016年9月14日 上午10:48:03 
 * @history:
 */
@Repository("navigateDAOImpl")
public class NavigateDAOImpl extends AMybatisTemplate implements INavigateDAO {

    @Override
    public int insert(Navigate data) {
        return super.insert(NAMESPACE.concat("insert_navigate"), data);
    }

    @Override
    public int delete(Navigate data) {
        return super.delete(NAMESPACE.concat("delete_navigate"), data);
    }

    @Override
    public Navigate select(Navigate condition) {
        return super.select(NAMESPACE.concat("select_navigate"), condition,
            Navigate.class);
    }

    @Override
    public long selectTotalCount(Navigate condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_navigate_count"), condition);
    }

    @Override
    public List<Navigate> selectList(Navigate condition) {
        return super.selectList(NAMESPACE.concat("select_navigate"), condition,
            Navigate.class);
    }

    @Override
    public List<Navigate> selectList(Navigate condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_navigate"), start,
            count, condition, Navigate.class);
    }

    @Override
    public int update(Navigate data) {
        return super.update("update_navigate", data);
    }

}
