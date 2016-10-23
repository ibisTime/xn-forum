package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.ProdOrder;

public interface IProdOrderBO extends IPaginableBO<ProdOrder> {

    public boolean isProdOrderExist(String code);

    public String saveProdOrder(String userId, String productCode,
            Integer quantity, Long payPrice);

    public int removeProdOrder(String code);

    public int refreshProdOrderStatus(String code, String status, String taker,
            String remark);

    public int refreshProdOrderStatus(ProdOrder data);

    public List<ProdOrder> queryProdOrderList(ProdOrder condition);

    public ProdOrder getProdOrder(String code);

}
