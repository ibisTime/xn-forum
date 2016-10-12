package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.IProdOrderAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.ProdOrder;
import com.std.forum.dto.req.XN610330Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 分页查询我的订单
 * @author: zuixian 
 * @since: 2016年10月12日 下午2:35:51 
 * @history:
 */
public class XN610330 extends AProcessor {

    private IProdOrderAO prodOrder = SpringContextHolder
        .getBean(IProdOrderAO.class);

    private XN610330Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ProdOrder condition = new ProdOrder();
        condition.setPayer(req.getUserId());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IProdOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return prodOrder.queryProdOrderPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610330Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}
