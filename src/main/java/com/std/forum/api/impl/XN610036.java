package com.std.forum.api.impl;

import com.std.forum.ao.ISplateTemplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610036Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 详情查询小板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午7:23:53 
 * @history:
 */
public class XN610036 extends AProcessor {
    private ISplateTemplateAO splateTemplateAO = SpringContextHolder
        .getBean(ISplateTemplateAO.class);

    private XN610036Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return splateTemplateAO.getSplateTemplate(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610036Req.class);
        StringValidater.validateNumber(req.getCode());
    }

}
