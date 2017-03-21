package com.std.forum.api.impl;

import com.std.forum.ao.ISplateTemplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610031Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 删除小板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午7:10:59 
 * @history:
 */
public class XN610031 extends AProcessor {
    private ISplateTemplateAO splateTemplateAO = SpringContextHolder
        .getBean(ISplateTemplateAO.class);

    private XN610031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        splateTemplateAO.dropSplateTemplate(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610031Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
