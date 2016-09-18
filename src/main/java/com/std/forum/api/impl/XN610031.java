package com.std.forum.api.impl;

import com.std.forum.ao.INavigateAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.NavigateConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.domain.Navigate;
import com.std.forum.dto.req.XN610031Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 列表查询导航信息
 * @author: zuixian 
 * @since: 2016年9月14日 下午5:08:38 
 * @history:
 */
public class XN610031 extends AProcessor {

    private INavigateAO navigateAO = SpringContextHolder
        .getBean(INavigateAO.class);

    private XN610031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Navigate condition = NavigateConverter.converter(req);
        return navigateAO.queryNavigateList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610031Req.class);
    }

}
