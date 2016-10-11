package com.std.forum.bo.impl;

import org.springframework.stereotype.Component;

import com.std.forum.bo.IUserBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.domain.User;
import com.std.forum.dto.req.XN805076Req;
import com.std.forum.dto.res.XN805076Res;
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
     * @see com.std.forum.bo.IUserBO#doGetUser(java.lang.String)
     */
    @Override
    public User doGetUser(String userId) {
        return null;
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
}
