package com.std.forum.api.impl;

import com.std.forum.ao.IPlateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.PlateConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.domain.Plate;
import com.std.forum.dto.req.XN610031Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 列表查询板块信息
 * @author: zuixian 
 * @since: 2016年9月19日 下午1:44:17 
 * @history:
 */
public class XN610031 extends AProcessor {

    private IPlateAO plateAO = SpringContextHolder.getBean(IPlateAO.class);

    private XN610031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Plate condition = PlateConverter.converter(req);
        return plateAO.queryPlateList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610031Req.class);
    }

}
