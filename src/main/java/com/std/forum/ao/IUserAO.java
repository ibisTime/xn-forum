/**
 * @Title IUserAO.java 
 * @Package com.xnjr.mall.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 下午12:31:53 
 * @version V1.0   
 */
package com.std.forum.ao;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.User;
import com.std.forum.dto.req.XN805054Req;
import com.std.forum.dto.req.XN805076Req;

/** 
 * @author: xieyj 
 * @since: 2016年7月26日 下午12:31:53 
 * @history:
 */
public interface IUserAO {
    public String doRegister(XN805076Req data);

    public Paginable<User> queryUserPage(XN805054Req req);

    public Object getDetailUser(String tokenId, String userId);

    public void doSignToday(String userId, String location);

}
