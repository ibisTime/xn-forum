package com.std.forum.api.impl;

import com.std.forum.ao.IBplateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610026Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 详情查询大板块
 * @author: asus 
 * @since: 2017年3月20日 下午6:42:19 
 * @history:
 */
public class XN610026 extends AProcessor {
    private IBplateAO bplateAO = SpringContextHolder.getBean(IBplateAO.class);

    private XN610026Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bplateAO.getBplate(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610026Req.class);
        StringValidater.validateNumber(req.getCode());
    }
}
