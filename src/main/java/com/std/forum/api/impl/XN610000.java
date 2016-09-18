package com.std.forum.api.impl;

import com.std.forum.ao.ISiteAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.SiteConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Site;
import com.std.forum.dto.req.XN610000Req;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 站点新增
 * @author: xieyj 
 * @since: 2016年8月29日 下午2:38:43 
 * @history:
 */
public class XN610000 extends AProcessor {

    private ISiteAO siteAO = SpringContextHolder.getBean(ISiteAO.class);

    private XN610000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Site data = SiteConverter.converter(req);
        return new PKCodeRes(siteAO.addSite(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610000Req.class);
        StringValidater.validateBlank(req.getName(), req.getLongitude(),
            req.getLatitude(), req.getUserId(), req.getPriority(),
            req.getDomain(), req.getLogo(), req.getAddress(),
            req.getTelephone(), req.getDescription(), req.getEmail(),
            req.getQrCode());
    }
}
