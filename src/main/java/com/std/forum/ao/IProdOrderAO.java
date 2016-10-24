package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.ProdOrder;

public interface IProdOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void takeYes(String orderCode, String takeNote);

    public void takeNo(String orderCode, String takeNote);

    public Paginable<ProdOrder> queryProdOrderPage(int start, int limit,
            ProdOrder condition);

    public List<ProdOrder> queryProdOrderList(ProdOrder condition);

    public ProdOrder getProdOrder(String code);

}
