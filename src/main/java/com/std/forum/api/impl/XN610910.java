package com.std.forum.api.impl;

import com.std.forum.ao.ISYSConfigAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.SYSConfig;
import com.std.forum.dto.req.XN610910Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 修改系统参数
 * @author: xieyj 
 * @since: 2016年9月17日 下午1:54:21 
 * @history:
 */
public class XN610910 extends AProcessor {
    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XN610910Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSConfig data = new SYSConfig();
        data.setId(req.getId());
        data.setCvalue(req.getCvalue());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        sysConfigAO.editSYSConfig(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610910Req.class);
        StringValidater.validateBlank(req.getCvalue(), req.getUpdater());

    }

}
