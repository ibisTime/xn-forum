package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.ProdOrder;
import com.std.forum.enums.EProdOrderStatus;

public interface IProdOrderBO extends IPaginableBO<ProdOrder> {

    public boolean isProdOrderExist(String code);

    public String saveProdOrder(String userId, String productCode,
            Integer quantity, Long payPrice, String remark);

    public int removeProdOrder(String code);

    public ProdOrder refreshStatus(String code, EProdOrderStatus toStatus,
            String takeNote);

    public List<ProdOrder> queryProdOrderList(ProdOrder condition);

    public ProdOrder getProdOrder(String code);

}
