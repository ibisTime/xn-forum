package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.IBannerAO;
import com.std.forum.ao.IMenuAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Banner;
import com.std.forum.dto.req.XN610105Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 分页查询banner
 * @author: asus 
 * @since: 2017年3月22日 上午9:55:36 
 * @history:
 */
public class XN610105 extends AProcessor {
    private IBannerAO bannerAO = SpringContextHolder.getBean(IBannerAO.class);

    private XN610105Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Banner condition = new Banner();
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
        return bannerAO.queryBannerPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610105Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
