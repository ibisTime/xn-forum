package com.std.forum.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610045Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 对帖子/评论进行批量审核
 * @author: xieyj 
 * @since: 2016年10月23日 下午7:12:45 
 * @history:
 */
public class XN610045 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610045Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        postAO.approvePostList(req.getCodeList(), req.getApprover(),
            req.getApproveResult(), req.getApproveNote(), req.getType());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610045Req.class);
        StringValidater.validateBlank(req.getApprover(),
            req.getApproveResult(), req.getApproveNote(), req.getType());
        if (CollectionUtils.isEmpty(req.getCodeList())) {
            throw new BizException("xn000000", "编号列表不能为空");
        }
    }
}
