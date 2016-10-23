package com.std.forum.api.impl;

import com.std.forum.ao.IPlateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.PlateConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Plate;
import com.std.forum.dto.req.XN610020Req;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 新增板块
 * @author: zuixian 
 * @since: 2016年9月19日 下午1:43:25 
 * @history:
 */
public class XN610020 extends AProcessor {

    private IPlateAO plateAO = SpringContextHolder.getBean(IPlateAO.class);

    private XN610020Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Plate data = PlateConverter.converter(req);
        return new PKCodeRes(plateAO.addPlate(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610020Req.class);
        StringValidater.validateBlank(req.getKind(), req.getName(),
            req.getStatus(), req.getLocation(), req.getOrderNo(),
            req.getUserId(), req.getPic(), req.getSiteCode(), req.getUpdater());
    }
}
