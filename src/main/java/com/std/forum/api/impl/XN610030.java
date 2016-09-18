package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.INavigateAO;
import com.std.forum.ao.ISiteAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.NavigateConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Navigate;
import com.std.forum.dto.req.XN610030Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 分页查询导航信息
 * @author: zuixian 
 * @since: 2016年9月14日 下午5:08:59 
 * @history:
 */
public class XN610030 extends AProcessor {

    private INavigateAO navigateAO = SpringContextHolder
        .getBean(INavigateAO.class);

    private XN610030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Navigate condition = NavigateConverter.converter(req);
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISiteAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return navigateAO.queryNavigatePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610030Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
