package com.std.forum.api.impl;

import com.std.forum.ao.ISYSConfigAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.SYSConfig;
import com.std.forum.dto.req.XN809010Req;
import com.std.forum.dto.res.PKIdRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 新增系统参数
 * @author: xieyj 
 * @since: 2016年9月17日 下午1:51:37 
 * @history:
 */
public class XN809010 extends AProcessor {

    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XN809010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSConfig data = new SYSConfig();
        data.setToSystem("8");// 8 代表生意家 作为服务时启用该字段
        data.setCkey(req.getCkey());
        data.setCvalue(req.getCvalue());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return new PKIdRes(sysConfigAO.addSYSConfig(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN809010Req.class);
        StringValidater.validateBlank(req.getCkey(), req.getCvalue(),
            req.getNote(), req.getUpdater());

    }

}
