package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.ISubsystemDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Subsystem;

@Repository("subsystemDAOImpl")
public class SubsystemDAOImpl extends AMybatisTemplate implements ISubsystemDAO {

    @Override
    public int insert(Subsystem data) {
        return super.insert(NAMESPACE.concat("insert_subsystem"), data);
    }

    @Override
    public int delete(Subsystem data) {
        return super.delete(NAMESPACE.concat("delete_subsystem"), data);
    }

    @Override
    public Subsystem select(Subsystem condition) {
        return super.select(NAMESPACE.concat("select_subsystem"), condition,
            Subsystem.class);
    }

    @Override
    public Long selectTotalCount(Subsystem condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_subsystem_count"), condition);
    }

    @Override
    public List<Subsystem> selectList(Subsystem condition) {
        return super.selectList(NAMESPACE.concat("select_subsystem"),
            condition, Subsystem.class);
    }

    @Override
    public List<Subsystem> selectList(Subsystem condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_subsystem"), start,
            count, condition, Subsystem.class);
    }

    @Override
    public int update(Subsystem data) {
        return super.update(NAMESPACE.concat("update_subsystem"), data);
    }

}
