package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.ISiteAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.SiteConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Site;
import com.std.forum.dto.req.XN610010Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 分页查询站点信息
 * @author: zuixian 
 * @since: 2016年9月13日 下午4:24:25 
 * @history:
 */
public class XN610010 extends AProcessor {

    private ISiteAO siteAO = SpringContextHolder.getBean(ISiteAO.class);

    private XN610010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Site condition = SiteConverter.converter(req);
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISiteAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return siteAO.querySitePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610010Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
