package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610041Reqt;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 草稿发帖
 * @author: xieyj 
 * @since: 2016年10月13日 下午1:00:19 
 * @history:
 */
public class XN610041t extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610041Reqt req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = postAO.draftPublishPost(req.getCode(), req.getTitle(),
            req.getContent(), req.getPic(), req.getPlateCode(),
            req.getPublisher(), req.getIsPublish());
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610041Reqt.class);
        StringValidater.validateBlank(req.getContent(), req.getPlateCode(),
            req.getPublisher(), req.getIsPublish());
    }
}
