package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.IProdOrderAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.ProdOrder;
import com.std.forum.dto.req.XN610332Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 分页查询订单
 * @author: xieyj 
 * @since: 2016年10月28日 上午9:53:54 
 * @history:
 */
public class XN610332 extends AProcessor {

    private IProdOrderAO prodOrder = SpringContextHolder
        .getBean(IProdOrderAO.class);

    private XN610332Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ProdOrder condition = new ProdOrder();
        condition.setSiteCode(req.getSiteCode());
        condition.setProductName(req.getProductName());
        condition.setStatus(req.getStatus());
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
        req = JsonUtil.json2Bean(inputparams, XN610332Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}
