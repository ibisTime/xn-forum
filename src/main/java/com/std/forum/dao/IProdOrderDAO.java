package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.ProdOrder;

public interface IProdOrderDAO extends IBaseDAO<ProdOrder> {
    String NAMESPACE = IProdOrderDAO.class.getName().concat(".");

    public int update(ProdOrder data);

    public int updateStatus(ProdOrder data);
}
