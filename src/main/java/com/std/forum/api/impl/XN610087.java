package com.std.forum.api.impl;

import com.std.forum.ao.IMenuAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.dto.req.XN610087Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 详情查询
 * @author: asus 
 * @since: 2017年3月21日 下午2:30:51 
 * @history:
 */
public class XN610087 extends AProcessor {
    private IMenuAO menuAO = SpringContextHolder.getBean(IMenuAO.class);

    private XN610087Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return menuAO.getMenu(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610087Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
