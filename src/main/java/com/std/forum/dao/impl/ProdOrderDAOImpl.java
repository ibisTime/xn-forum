package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.IProdOrderDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.ProdOrder;

@Repository("prodOrderDAOImpl")
public class ProdOrderDAOImpl extends AMybatisTemplate implements IProdOrderDAO {

    @Override
    public int insert(ProdOrder data) {
        return super.insert(NAMESPACE.concat("insert_prodOrder"), data);
    }

    @Override
    public int delete(ProdOrder data) {
        return super.delete(NAMESPACE.concat("delete_prodOrder"), data);
    }

    @Override
    public ProdOrder select(ProdOrder condition) {
        return super.select(NAMESPACE.concat("select_prodOrder"), condition,
            ProdOrder.class);
    }

    @Override
    public Long selectTotalCount(ProdOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_prodOrder_count"), condition);
    }

    @Override
    public List<ProdOrder> selectList(ProdOrder condition) {
        return super.selectList(NAMESPACE.concat("select_prodOrder"),
            condition, ProdOrder.class);
    }

    @Override
    public List<ProdOrder> selectList(ProdOrder condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_prodOrder"), start,
            count, condition, ProdOrder.class);
    }

    @Override
    public int update(ProdOrder data) {
        return super.update(NAMESPACE.concat("update_prodOrder"), data);
    }

    @Override
    public int updateStatus(ProdOrder data) {
        return super.update(NAMESPACE.concat("update_prodOrder_status"), data);
    }
}
