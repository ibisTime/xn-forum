package com.std.forum.api.impl;

import com.std.forum.ao.INavigateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.NavigateConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Navigate;
import com.std.forum.dto.req.XN610020Req;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 新增导航
 * @author: zuixian 
 * @since: 2016年9月14日 下午5:09:40 
 * @history:
 */
public class XN610020 extends AProcessor {

    private INavigateAO navigateAO = SpringContextHolder
        .getBean(INavigateAO.class);

    private XN610020Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Navigate data = NavigateConverter.converter(req);
        return new PKCodeRes(navigateAO.addNavigate(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610020Req.class);
        StringValidater.validateBlank(req.getName(), req.getUrl(),
            req.getPic(), req.getOrderNo(), req.getStatus(), req.getType(),
            req.getIsGlobal(), req.getParentCode(), req.getUserId());
    }
}
