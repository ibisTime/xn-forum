package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610044Reqt;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 对帖子/评论进行审核
 * @author: xieyj 
 * @since: 2016年10月23日 下午7:12:45 
 * @history:
 */
public class XN610044t extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610044Reqt req = null;

    @Override
    public Object doBusiness() throws BizException {
        postAO.approvePost(req.getCode(), req.getApprover(),
            req.getApproveResult(), req.getApproveNote(), req.getType());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610044Reqt.class);
        StringValidater.validateBlank(req.getCode(), req.getApproveResult(),
            req.getApprover(), req.getApproveNote(), req.getType());
    }
}
