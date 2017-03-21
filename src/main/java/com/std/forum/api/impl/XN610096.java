package com.std.forum.api.impl;

import com.std.forum.ao.ISubsystemAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610096Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 详情查询子系统配置
 * @author: asus 
 * @since: 2017年3月21日 下午5:56:01 
 * @history:
 */
public class XN610096 extends AProcessor {
    private ISubsystemAO subsystemAO = SpringContextHolder
        .getBean(ISubsystemAO.class);

    private XN610096Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return subsystemAO.getSubsystem(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610096Req.class);
        StringValidater.validateNumber(req.getCode());
    }
}
