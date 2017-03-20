package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.IBplateDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Bplate;

@Repository("bplateDAOImpl")
public class BplateDAOImpl extends AMybatisTemplate implements IBplateDAO {

    @Override
    public int insert(Bplate data) {
        return super.insert(NAMESPACE.concat("insert_bplate"), data);
    }

    @Override
    public int delete(Bplate data) {
        return super.delete(NAMESPACE.concat("delete_bplate"), data);
    }

    @Override
    public Bplate select(Bplate condition) {
        return super.select(NAMESPACE.concat("select_bplate"), condition,
            Bplate.class);
    }

    @Override
    public Long selectTotalCount(Bplate condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_bplate_count"),
            condition);
    }

    @Override
    public List<Bplate> selectList(Bplate condition) {
        return super.selectList(NAMESPACE.concat("select_bplate"), condition,
            Bplate.class);
    }

    @Override
    public List<Bplate> selectList(Bplate condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bplate"), start,
            count, condition, Bplate.class);
    }

    @Override
    public int update(Bplate data) {
        return super.update(NAMESPACE.concat("update_bplate"), data);
    }

}
