/**
 * @Title UserAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 下午12:32:53 
 * @version V1.0   
 */
package com.std.forum.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IUserAO;
import com.std.forum.bo.IRuleBO;
import com.std.forum.bo.IUserBO;
import com.std.forum.dto.req.XN805076Req;
import com.std.forum.enums.ERuleKind;
import com.std.forum.enums.ERuleType;

/** 
 * 用户AO
 * @author: xieyj 
 * @since: 2016年7月26日 下午12:32:53 
 * @history:
 */
@Service
public class UserAOImpl implements IUserAO {

    @Autowired
    IUserBO userBO;

    @Autowired
    IRuleBO ruleBO;

    /** 
     * @see com.std.forum.ao.IUserAO#doRegister(com.std.forum.dto.req.XN805076Req)
     */
    @Override
    public String doRegister(XN805076Req data) {
        Long amount = ruleBO.getRuleByCondition(ERuleKind.JF, ERuleType.ZC);
        data.setAmount(String.valueOf(amount));
        return userBO.doRegister(data);
    }
}
