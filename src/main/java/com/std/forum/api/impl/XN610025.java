package com.std.forum.api.impl;

import com.std.forum.ao.IPlateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610025Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 新建站点初始化类别和板块
 * @author: xieyj 
 * @since: 2016年10月10日 下午5:40:38 
 * @history:
 */
public class XN610025 extends AProcessor {

    private IPlateAO plateAO = SpringContextHolder.getBean(IPlateAO.class);

    private XN610025Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        plateAO.initPlatPlate(req.getCompanyCode(), req.getUserId());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610025Req.class);
        StringValidater.validateBlank(req.getCompanyCode(), req.getUserId());
    }
}
