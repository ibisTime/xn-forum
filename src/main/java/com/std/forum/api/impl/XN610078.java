package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610078Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 根据评论编号搜帖子详情
 * @author: xieyj 
 * @since: 2016年10月13日 下午2:10:14 
 * @history:
 */
public class XN610078 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610078Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return postAO.getPostByCommentCode(req.getCommentCode(),
            req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610078Req.class);
        StringValidater.validateBlank(req.getCommentCode());
    }
}
