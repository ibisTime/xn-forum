package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.ISplateTemplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.SplateTemplate;
import com.std.forum.dto.req.XN610035Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 分页查询小板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午6:13:58 
 * @history:
 */
public class XN610035 extends AProcessor {
    private ISplateTemplateAO splateTemplateAO = SpringContextHolder
        .getBean(ISplateTemplateAO.class);

    private XN610035Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SplateTemplate condition = new SplateTemplate();
        condition.setName(req.getName());
        condition.setBplateCode(req.getParentCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISplateTemplateAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return splateTemplateAO
            .querySplateTemplatePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610035Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}
