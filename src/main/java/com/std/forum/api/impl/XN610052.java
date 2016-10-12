package com.std.forum.api.impl;

import com.std.forum.ao.IPostAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610052Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 版主删除帖子
 * @author: zuixian 
 * @since: 2016年9月19日 下午4:44:53 
 * @history:
 */
public class XN610052 extends AProcessor {

    private IPostAO postAO = SpringContextHolder.getBean(IPostAO.class);

    private XN610052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new BooleanRes(postAO.removePostByGL(req.getCode()) > 0 ? true
                : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610052Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
