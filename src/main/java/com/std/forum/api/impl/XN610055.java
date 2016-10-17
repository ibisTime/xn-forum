package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610055Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 对帖子内容进行审核
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:50:18 
 * @history:
 */
public class XN610055 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610055Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        postAO.approvePost(req.getCode(), req.getStatus(), req.getApprover(),
            req.getApproveNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610055Req.class);
        StringValidater.validateBlank(req.getCode(), req.getStatus(),
            req.getApprover(), req.getApproveNote());
    }
}
