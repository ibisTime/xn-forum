package com.std.forum.api.impl;

import com.std.forum.ao.ISplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610046Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 详情查询小板块
 * @author: asus 
 * @since: 2017年3月20日 下午8:20:23 
 * @history:
 */
public class XN610046 extends AProcessor {
    private ISplateAO splateAO = SpringContextHolder.getBean(ISplateAO.class);

    private XN610046Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return splateAO.getSplate(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610046Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
