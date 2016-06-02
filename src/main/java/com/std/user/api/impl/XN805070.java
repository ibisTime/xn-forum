package com.std.user.api.impl;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.common.PhoneUtil;
import com.std.user.dto.req.XN805070Req;
import com.std.user.dto.res.XN805070Res;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 代注册(无实名认证)
 * @author: myb858 
 * @since: 2015年8月23日 下午1:48:57 
 * @history:
 */
public class XN805070 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805070Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XN805070Res(userAO.doAddUser(req.getMobile(),
            req.getRealName(), req.getUserReferee(), req.getUpdater(),
            req.getRemark(), req.getKind()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805070Req.class);
        PhoneUtil.checkMobile(req.getMobile());// 判断格式
    }
}
