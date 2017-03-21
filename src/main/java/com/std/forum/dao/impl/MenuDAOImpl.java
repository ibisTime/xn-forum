package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.IMenuDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Menu;

@Repository("menuDAOImpl")
public class MenuDAOImpl extends AMybatisTemplate implements IMenuDAO {

    @Override
    public int insert(Menu data) {
        return super.insert(NAMESPACE.concat("insert_menu"), data);
    }

    @Override
    public int delete(Menu data) {
        return super.delete(NAMESPACE.concat("delete_menu"), data);
    }

    @Override
    public Menu select(Menu condition) {
        return super.select(NAMESPACE.concat("select_menu"), condition,
            Menu.class);
    }

    @Override
    public Long selectTotalCount(Menu condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_menu_count"),
            condition);
    }

    @Override
    public List<Menu> selectList(Menu condition) {
        return super.selectList(NAMESPACE.concat("select_menu"), condition,
            Menu.class);
    }

    @Override
    public List<Menu> selectList(Menu condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_menu"), start, count,
            condition, Menu.class);
    }

    @Override
    public int updateByGlobal(Menu data) {
        return super.update(NAMESPACE.concat("update_menu_byglobal"), data);
    }

    @Override
    public int updateByLocal(Menu data) {
        return super.update(NAMESPACE.concat("update_menu_bylocal"), data);
    }

}
