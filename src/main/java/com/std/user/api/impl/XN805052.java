package com.std.user.api.impl;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805052Req;
import com.std.user.dto.res.XN805052Res;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 1.13、 注销/激活用户
 * @author: myb858 
 * @since: 2016年5月24日 下午5:41:15 
 * @history:
 */
public class XN805052 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doStatusUser(req.getUserId(), req.getToStatus(),
            req.getUpdater(), req.getRemark());
        return new XN805052Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805052Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getToStatus(),
            req.getUpdater());

    }

}
