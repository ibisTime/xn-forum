package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.IPlateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.PlateConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Plate;
import com.std.forum.dto.req.XN610030Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 分页查询版块信息
 * @author: zuixian 
 * @since: 2016年9月19日 下午1:44:05 
 * @history:
 */
public class XN610030 extends AProcessor {

    private IPlateAO plateAO = SpringContextHolder.getBean(IPlateAO.class);

    private XN610030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Plate condition = PlateConverter.converter(req);
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IPlateAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return plateAO.queryPlatePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610030Req.class);
    }

}
