package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.IMenuAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Menu;
import com.std.forum.dto.req.XN610085Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 分页查询菜单
 * @author: asus 
 * @since: 2017年3月21日 下午2:06:20 
 * @history:
 */
public class XN610085 extends AProcessor {
    private IMenuAO menuAO = SpringContextHolder.getBean(IMenuAO.class);

    private XN610085Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Menu condition = new Menu();
        condition.setName(req.getName());
        condition.setBelong(req.getBelong());
        condition.setCompanyCode(req.getCompanyCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isEmpty(orderColumn)) {
            orderColumn = IMenuAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return menuAO.queryMenuPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610085Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}
