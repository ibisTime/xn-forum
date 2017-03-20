package com.std.forum.api.impl;

import com.std.forum.ao.ISplateTemplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610030Req;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 新增小板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午6:58:44 
 * @history:
 */
public class XN610030 extends AProcessor {
    private ISplateTemplateAO splateTemplateAO = SpringContextHolder
        .getBean(ISplateTemplateAO.class);

    private XN610030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(splateTemplateAO.addSplateTemplate(req.getName(),
            req.getParentCode(), req.getPic(), req.getOrderNo(),
            req.getUpdater()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610030Req.class);
        StringValidater.validateBlank(req.getName(), req.getParentCode(),
            req.getPic(), req.getOrderNo(), req.getUpdater());
    }

}
