package com.std.forum.api.impl;

import com.std.forum.ao.IBplateTemplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610016Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 详情查询大板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午5:28:26 
 * @history:
 */
public class XN610016 extends AProcessor {
    private IBplateTemplateAO bplateTemplateAO = SpringContextHolder
        .getBean(IBplateTemplateAO.class);

    private XN610016Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bplateTemplateAO.getBplateTemplate(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610016Req.class);
        StringValidater.validateNumber(req.getCode());
    }

}
