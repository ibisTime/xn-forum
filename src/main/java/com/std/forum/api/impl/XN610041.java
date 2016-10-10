package com.std.forum.api.impl;

import com.std.forum.ao.IPlateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.PlateConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Plate;
import com.std.forum.dto.req.XN610041Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 修改板块信息
 * @author: xieyj 
 * @since: 2016年10月10日 下午5:40:38 
 * @history:
 */
public class XN610041 extends AProcessor {

    private IPlateAO plateAO = SpringContextHolder.getBean(IPlateAO.class);

    private XN610041Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Plate data = PlateConverter.converter(req);
        plateAO.editPlate(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610041Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getPic(), req.getUpdater());
    }
}
