package com.std.forum.bo.impl;

import org.springframework.stereotype.Component;

import com.std.forum.bo.IUserBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.domain.User;
import com.std.forum.dto.req.XN805076Req;
import com.std.forum.dto.req.XN805300Req;
import com.std.forum.dto.req.XN805901Req;
import com.std.forum.dto.res.XN805076Res;
import com.std.forum.dto.res.XN805901Res;
import com.std.forum.exception.BizException;
import com.std.forum.http.BizConnecter;
import com.std.forum.http.JsonUtils;

/**
 * @author: xieyj 
 * @since: 2016年5月30日 上午9:28:30 
 * @history:
 */
@Component
public class UserBOImpl extends PaginableBOImpl<User> implements IUserBO {

    /** 
     * @see com.xnjr.mall.bo.IUserBO#getRemoteUser(java.lang.String)
     */
    @Override
    public XN805901Res getRemoteUser(String tokenId, String userId) {
        XN805901Req req = new XN805901Req();
        req.setTokenId(tokenId);
        req.setUserId(userId);
        XN805901Res res = BizConnecter.getBizData("805901",
            JsonUtils.object2Json(req), XN805901Res.class);
        if (res == null) {
            throw new BizException("XN000000", "编号为" + userId + "的用户不存在");
        }
        return res;
    }

    /** 
     * @see com.std.forum.bo.IUserBO#doRegister(com.std.forum.dto.req.XN805076Req)
     */
    @Override
    public String doRegister(XN805076Req req) {
        XN805076Res res = BizConnecter.getBizData("805076",
            JsonUtils.object2Json(req), XN805076Res.class);
        return res.getUserId();
    }

    /** 
     * @see com.std.forum.bo.IUserBO#doTransfer(java.lang.String, java.lang.String, java.lang.Long, java.lang.String, java.lang.String)
     */
    @Override
    public void doTransfer(String userId, String direction, Long amount,
            String remark, String refNo) {
        XN805300Req req = new XN805300Req();
        req.setUserId(userId);
        req.setDirection(direction);
        req.setAmount(String.valueOf(amount));
        req.setRemark(remark);
        req.setRefNo(refNo);
        BizConnecter.getBizData("805300", JsonUtils.object2Json(req),
            Object.class);
    }
}
