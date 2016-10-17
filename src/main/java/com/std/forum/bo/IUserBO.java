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
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.User;
import com.std.forum.dto.req.XN805054Req;
import com.std.forum.dto.req.XN805076Req;
import com.std.forum.dto.res.XN805056Res;
import com.std.forum.dto.res.XN805901Res;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午8:09:47 
 * @history:
 */
public interface IUserBO extends IPaginableBO<User> {

    public XN805056Res getDetailUser(String tokenId, String userId);

    public XN805901Res getRemoteUser(String tokenId, String userId);

    /**
     * 注册
     * @param req
     * @return 
     * @create: 2016年10月12日 上午5:38:41 xieyj
     * @history:
     */
    public String doRegister(XN805076Req req);

    /**
     * 
     */
    public void doSign(String userId, String location, Long amount);

    /**
     * 加减积分
     * @param userId
     * @param direction
     * @param amount
     * @param remark
     * @param refNo 
     * @create: 2016年10月12日 上午8:13:47 xieyj
     * @history:
     */
    public void doTransfer(String userId, String direction, Long amount,
            String remark, String refNo);

    public Paginable<User> queryUserPage(XN805054Req req);
}
