package com.std.forum.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.ao.ICategoryAO;
import com.std.forum.api.AProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.core.StringValidater;
import com.std.forum.domain.Category;
import com.std.forum.dto.req.XN610802Req;
import com.std.forum.dto.res.BooleanRes;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/**
 * 修改类别
 * @author: xieyj 
 * @since: 2016年11月16日 下午5:45:12 
 * @history:
 */
public class XN610802 extends AProcessor {

    private ICategoryAO categoryAO = SpringContextHolder
        .getBean(ICategoryAO.class);

    private XN610802Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Category data = new Category();
        data.setCode(req.getCode());
        data.setParentCode(req.getParentCode());
        data.setType(req.getType());
        data.setName(req.getName());
        data.setPic(req.getPic());
        if (StringUtils.isNotBlank(req.getOrderNo())) {
            data.setOrderNo(Integer.valueOf(req.getOrderNo()));
        }
        data.setCompanyCode(req.getCompanyCode());
        categoryAO.editCategory(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610802Req.class);
        StringValidater.validateBlank(req.getCode(), req.getParentCode(),
            req.getType(), req.getName(), req.getCompanyCode());
    }
}
