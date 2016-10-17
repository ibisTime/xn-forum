package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.ProdOrder;

public interface IProdOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addProdOrder(ProdOrder data);

    public int dropProdOrder(String code);

    public int takeProduct(String code, String taker, String remark);

    public int invalidProdOrder(String code, String takeNote);

    public Paginable<ProdOrder> queryProdOrderPage(int start, int limit,
            ProdOrder condition);

    public List<ProdOrder> queryProdOrderList(ProdOrder condition);

    public ProdOrder getProdOrder(String code);

}
