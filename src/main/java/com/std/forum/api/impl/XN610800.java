package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.ICategoryAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Category;
import com.std.forum.dto.req.XN610800Req;
import com.std.forum.dto.res.PKCodeRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 新增类别，类别分为大类和小类，新增大类时，父节点填0
 * @author: xieyj 
 * @since: 2016年11月16日 下午5:18:26 
 * @history:
 */
public class XN610800 extends AProcessor {

    private ICategoryAO categoryAO = SpringContextHolder
        .getBean(ICategoryAO.class);

    private XN610800Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Category data = new Category();
        data.setParentCode(req.getParentCode());
        data.setType(req.getType());
        data.setName(req.getName());
        data.setPic(req.getPic());
        if (StringUtils.isNotBlank(req.getOrderNo())) {
            data.setOrderNo(Integer.valueOf(req.getOrderNo()));
        }
        data.setCompanyCode(req.getCompanyCode());
        return new PKCodeRes(categoryAO.addCategory(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610800Req.class);
        StringValidater.validateBlank(req.getParentCode(), req.getType(),
            req.getName(), req.getCompanyCode());
    }
}
