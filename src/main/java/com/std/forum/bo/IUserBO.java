/**
 * @Title IUserBO.java 
 * @Package com.std.forum.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午8:09:47 
 * @version V1.0   
 */
package com.std.forum.bo;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.User;
import com.std.forum.dto.req.XN805076Req;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午8:09:47 
 * @history:
 */
public interface IUserBO extends IPaginableBO<User> {

    /**
     * 查询用户的详细信息
     * @param userId
     * @return 
     * @create: 2016年8月29日 下午8:52:21 xieyj
     * @history:
     */
    public User doGetUser(String userId);

    /**
     * 注册
     * @param req
     * @return 
     * @create: 2016年10月12日 上午5:38:41 xieyj
     * @history:
     */
    public String doRegister(XN805076Req req);

}
