package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610900Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 统计我发的帖子等数据
 * @author: xieyj 
 * @since: 2016年10月23日 下午12:15:16 
 * @history:
 */
public class XN610900 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610900Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return postAO.totalPostNum(req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610900Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}
