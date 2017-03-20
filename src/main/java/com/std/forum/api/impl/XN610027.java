package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.IBplateAO;
import com.std.forum.ao.IBplateTemplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.domain.Bplate;
import com.std.forum.dto.req.XN610027Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 列表查询大板块
 * @author: asus 
 * @since: 2017年3月20日 下午6:13:58 
 * @history:
 */
public class XN610027 extends AProcessor {
    private IBplateAO bplateAO = SpringContextHolder.getBean(IBplateAO.class);

    private XN610027Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Bplate condition = new Bplate();
        condition.setName(req.getName());
        condition.setStatus(req.getStatus());
        condition.setCompanyCode(req.getCompanyCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBplateTemplateAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        return bplateAO.queryBplateList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610027Req.class);
    }

}
