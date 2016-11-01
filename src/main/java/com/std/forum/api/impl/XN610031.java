package com.std.forum.api.impl;

import com.std.forum.ao.IPlateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.domain.Plate;
import com.std.forum.dto.req.XN610031Req;
import com.std.forum.enums.EBoolean;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 列表查询版块信息(front)
 * @author: xieyj 
 * @since: 2016年10月23日 下午1:03:13 
 * @history:
 */
public class XN610031 extends AProcessor {

    private IPlateAO plateAO = SpringContextHolder.getBean(IPlateAO.class);

    private XN610031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Plate condition = new Plate();
        condition.setKind(req.getKind());
        condition.setUserId(req.getUserId());
        condition.setStatus(EBoolean.YES.getCode());
        condition.setSiteCode(req.getSiteCode());
        return plateAO.queryPlateList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610031Req.class);
    }

}
