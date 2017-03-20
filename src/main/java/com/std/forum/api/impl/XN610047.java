package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.ISplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.domain.Splate;
import com.std.forum.dto.req.XN610047Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 列表查询小板块
 * @author: asus 
 * @since: 2017年3月20日 下午8:13:22 
 * @history:
 */
public class XN610047 extends AProcessor {
    private ISplateAO splateAO = SpringContextHolder.getBean(ISplateAO.class);

    private XN610047Req req = null;

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
        return splateAO.querySplateList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610047Req.class);
    }
}
