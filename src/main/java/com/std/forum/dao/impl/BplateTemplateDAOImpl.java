package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.IBplateTemplateDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.BplateTemplate;

@Repository("bplateTemplateDAOImpl")
public class BplateTemplateDAOImpl extends AMybatisTemplate implements
        IBplateTemplateDAO {

    @Override
    public int insert(BplateTemplate data) {
        return super.insert(NAMESPACE.concat("insert_bplateTemplate"), data);
    }

    @Override
    public int delete(BplateTemplate data) {
        return super.delete(NAMESPACE.concat("delete_bplateTemplate"), data);
    }

    @Override
    public BplateTemplate select(BplateTemplate condition) {
        return super.select(NAMESPACE.concat("select_bplateTemplate"),
            condition, BplateTemplate.class);
    }

    @Override
    public Long selectTotalCount(BplateTemplate condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_bplateTemplate_count"), condition);
    }

    @Override
    public List<BplateTemplate> selectList(BplateTemplate condition) {
        return super.selectList(NAMESPACE.concat("select_bplateTemplate"),
            condition, BplateTemplate.class);
    }

    @Override
    public List<BplateTemplate> selectList(BplateTemplate condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_bplateTemplate"),
            start, count, condition, BplateTemplate.class);
    }

    @Override
    public int update(BplateTemplate data) {
        return super.update(NAMESPACE.concat("update_bplateTemplate"), data);
    }

}
