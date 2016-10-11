/**
 * @Title IUserAO.java 
 * @Package com.xnjr.mall.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 下午12:31:53 
 * @version V1.0   
 */
package com.std.forum.ao;

import com.std.forum.dto.req.XN805076Req;

/** 
 * @author: xieyj 
 * @since: 2016年7月26日 下午12:31:53 
 * @history:
 */
public interface IUserAO {
    public String doRegister(XN805076Req data);
}
