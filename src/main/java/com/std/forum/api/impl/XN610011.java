package com.std.forum.api.impl;

import com.std.forum.ao.IBplateTemplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610011Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 删除大板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午5:05:59 
 * @history:
 */
public class XN610011 extends AProcessor {
    private IBplateTemplateAO bplateTemplateAO = SpringContextHolder
        .getBean(IBplateTemplateAO.class);

    private XN610011Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bplateTemplateAO.dropBplateTemplate(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610011Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
