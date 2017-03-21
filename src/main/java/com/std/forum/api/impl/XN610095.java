package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.IMenuAO;
import com.std.forum.ao.ISubsystemAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Subsystem;
import com.std.forum.dto.req.XN610095Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 地方修改子系统配置
 * @author: asus 
 * @since: 2017年3月21日 下午5:56:01 
 * @history:
 */
public class XN610095 extends AProcessor {
    private ISubsystemAO subsystemAO = SpringContextHolder
        .getBean(ISubsystemAO.class);

    private XN610095Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Subsystem condition = new Subsystem();
        condition.setName(req.getName());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setBelong(req.getBelong());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isEmpty(orderColumn)) {
            orderColumn = IMenuAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return subsystemAO.querySubsystemPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610095Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
