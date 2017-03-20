package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.ISplateTemplateDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.SplateTemplate;

@Repository("splateTemplateDAOImpl")
public class SplateTemplateDAOImpl extends AMybatisTemplate implements
        ISplateTemplateDAO {

    @Override
    public int insert(SplateTemplate data) {
        return super.insert(NAMESPACE.concat("insert_splateTemplate"), data);
    }

    @Override
    public int delete(SplateTemplate data) {
        return super.delete(NAMESPACE.concat("delete_splateTemplate"), data);
    }

    @Override
    public SplateTemplate select(SplateTemplate condition) {
        return super.select(NAMESPACE.concat("select_splateTemplate"),
            condition, SplateTemplate.class);
    }

    @Override
    public Long selectTotalCount(SplateTemplate condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_splateTemplate_count"), condition);
    }

    @Override
    public List<SplateTemplate> selectList(SplateTemplate condition) {
        return super.selectList(NAMESPACE.concat("select_splateTemplate"),
            condition, SplateTemplate.class);
    }

    @Override
    public List<SplateTemplate> selectList(SplateTemplate condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_splateTemplate"),
            start, count, condition, SplateTemplate.class);
    }

    @Override
    public int update(SplateTemplate data) {
        return super.update(NAMESPACE.concat("update_splateTemplate"), data);
    }

}
