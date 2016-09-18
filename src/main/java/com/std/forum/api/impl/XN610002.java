package com.std.forum.api.impl;

import com.std.forum.ao.ISiteAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.SiteConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Site;
import com.std.forum.dto.req.XN610002Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 修改站点信息
 * @author: zuixian 
 * @since: 2016年9月13日 下午4:25:02 
 * @history:
 */
public class XN610002 extends AProcessor {

    private ISiteAO siteAO = SpringContextHolder.getBean(ISiteAO.class);

    private XN610002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Site data = SiteConverter.converter(req);
        return new BooleanRes(siteAO.editSite(data) > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610002Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getLongitude(), req.getLatitude(), req.getUserId(),
            req.getPriority(), req.getDomain(), req.getLogo(),
            req.getAddress(), req.getTelephone(), req.getDescription(),
            req.getEmail(), req.getQrCode());
    }
}
