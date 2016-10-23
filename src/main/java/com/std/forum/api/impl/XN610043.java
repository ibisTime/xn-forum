package com.std.forum.api.impl;

import com.std.forum.ao.IPostTalkAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610043Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 浏览帖子时，发现帖子内容存在问题，举报帖子/评论
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:50:03 
 * @history:
 */
public class XN610043 extends AProcessor {

    private IPostTalkAO postTalkAO = SpringContextHolder
        .getBean(IPostTalkAO.class);

    private XN610043Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        postTalkAO.reportPost(req.getCode(), req.getReporter(),
            req.getReportNote(), req.getType());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610043Req.class);
        StringValidater.validateBlank(req.getCode(), req.getReporter(),
            req.getReportNote(), req.getType());
    }
}
