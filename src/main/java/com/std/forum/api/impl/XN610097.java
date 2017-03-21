package com.std.forum.api.impl;

import com.std.forum.ao.ISubsystemAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610097Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 前端列表查询子系统配置
 * @author: asus 
 * @since: 2017年3月21日 下午7:50:31 
 * @history:
 */
public class XN610097 extends AProcessor {
    private ISubsystemAO subsystemAO = SpringContextHolder
        .getBean(ISubsystemAO.class);

    private XN610097Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return subsystemAO.querySubsystemList(req.getCompanyCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610097Req.class);
        StringValidater.validateNumber(req.getCompanyCode());
    }

}
