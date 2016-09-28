package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.PostConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Post;
import com.std.forum.dto.req.XN610054Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 浏览帖子时，发现帖子内容存在问题，举报帖子
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:50:03 
 * @history:
 */
public class XN610054 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610054Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Post data = PostConverter.converter(req);
        return new BooleanRes(postAO.reportPost(data) > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610054Req.class);
        StringValidater.validateBlank(req.getCode(), req.getReporter(),
            req.getReportNote());
    }

}
