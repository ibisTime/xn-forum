package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610063Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 草稿发帖
 * @author: xieyj 
 * @since: 2016年10月13日 下午1:00:19 
 * @history:
 */
public class XN610063 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610063Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        postAO.publishPost(req.getCode(), req.getTitle(), req.getContent(),
            req.getPic(), req.getPlateCode(), req.getPublisher());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610063Req.class);
        StringValidater.validateBlank(req.getCode(), req.getContent(),
            req.getPlateCode(), req.getPublisher());
    }
}
