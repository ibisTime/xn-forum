package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.ISplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Splate;
import com.std.forum.dto.req.XN610045Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 分页查询小板块
 * @author: asus 
 * @since: 2017年3月20日 下午8:13:22 
 * @history:
 */
public class XN610045 extends AProcessor {
    private ISplateAO splateAO = SpringContextHolder.getBean(ISplateAO.class);

    private XN610045Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Splate condition = new Splate();
        condition.setName(req.getName());
        condition.setBplateCode(req.getParentCode());
        condition.setStatus(req.getStatus());
        condition.setCompanyCode(req.getCompanyCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISplateAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return splateAO.querySplatePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610045Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
