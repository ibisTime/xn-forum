package com.std.forum.api.impl;

import com.std.forum.ao.INavigateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610021Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 删除导航
 * @author: zuixian 
 * @since: 2016年9月14日 下午5:09:30 
 * @history:
 */
public class XN610021 extends AProcessor {

    private INavigateAO navigateAO = SpringContextHolder
        .getBean(INavigateAO.class);

    private XN610021Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new BooleanRes(
            navigateAO.removeNavigate(req.getCode()) > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610021Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
