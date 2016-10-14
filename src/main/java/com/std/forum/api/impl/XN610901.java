package com.std.forum.api.impl;

import com.std.forum.ao.IUserAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.dto.req.XN805054Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 分页查询用户
 * @author: xieyj 
 * @since: 2016年10月12日 上午5:28:37 
 * @history:
 */
public class XN610901 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805054Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return userAO.queryUserPage(req);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805054Req.class);
    }
}
