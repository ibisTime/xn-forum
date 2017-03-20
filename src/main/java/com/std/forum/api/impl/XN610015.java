package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.IBplateTemplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.BplateTemplate;
import com.std.forum.dto.req.XN610015Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 分页查询大板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午5:20:10 
 * @history:
 */
public class XN610015 extends AProcessor {
    private IBplateTemplateAO bplateTemplateAO = SpringContextHolder
        .getBean(IBplateTemplateAO.class);

    private XN610015Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BplateTemplate condition = new BplateTemplate();
        condition.setName(req.getName());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBplateTemplateAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return bplateTemplateAO
            .queryBplateTemplatePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610015Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
