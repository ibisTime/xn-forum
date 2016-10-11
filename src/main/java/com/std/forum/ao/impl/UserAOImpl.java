/**
 * @Title UserAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 下午12:32:53 
 * @version V1.0   
 */
package com.std.forum.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IUserAO;
import com.std.forum.bo.IRuleBO;
import com.std.forum.bo.IUserBO;
import com.std.forum.domain.Rule;
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
        Long amount = 0L;
        // 获取注册送积分数量
        Rule condition = new Rule();
        condition.setKind(ERuleKind.JF.getCode());
        condition.setType(ERuleType.ZC.getCode());
        List<Rule> ruleList = ruleBO.queryRuleList(condition);
        if (!CollectionUtils.sizeIsEmpty(ruleList)) {
            Rule rule = ruleList.get(0);
            amount = Long.valueOf(rule.getValue());
        }
        data.setAmount(String.valueOf(amount));
        return userBO.doRegister(data);
    }
}
