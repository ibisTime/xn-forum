package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.ProdOrder;

public interface IProdOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addProdOrder(String userId, String productCode,
            Integer quantity);

    public int dropProdOrder(String code);

    public int takeProduct(String code, String remark);

    public void invalidProdOrder(String code, String takeNote);

    public Paginable<ProdOrder> queryProdOrderPage(int start, int limit,
            ProdOrder condition);

    public List<ProdOrder> queryProdOrderList(ProdOrder condition);

    public ProdOrder getProdOrder(String code);

}
