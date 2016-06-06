package com.std.user.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.domain.User;
import com.std.user.dto.req.XN805054Req;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 分页查询用户列表
 * @author: myb858 
 * @since: 2015年10月27日 下午4:02:23 
 * @history:
 */
public class XN805054 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805054Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        User condition = new User();
        condition.setLoginName(req.getLoginName());
        condition.setKind(req.getKind());
        condition.setLevel(req.getLevel());
        condition.setUserReferee(req.getUserReferee());
        condition.setMobileForLikeQuery(req.getMobile());

        condition.setIdKind(req.getIdKind());
        condition.setIdNo(req.getIdNo());
        condition.setRealName(req.getRealName());
        condition.setRoleCode(req.getRoleCode());
        condition.setStatus(req.getStatus());

        condition.setUpdater(req.getUpdater());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IUserAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return userAO.queryUserPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805054Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}
