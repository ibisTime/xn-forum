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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IUserAO;
import com.std.forum.bo.IPostBO;
import com.std.forum.bo.IRuleBO;
import com.std.forum.bo.IUserBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Post;
import com.std.forum.domain.User;
import com.std.forum.dto.req.XN805054Req;
import com.std.forum.dto.req.XN805076Req;
import com.std.forum.dto.res.XN805056Res;
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
    IPostBO postBO;

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

    /** 
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015-6-7 上午10:04:12 miyb
     * @history: 
     */
    @Override
    public Paginable<User> queryUserPage(XN805054Req req) {
        Paginable<User> userPage = userBO.queryUserPage(req);
        List<User> userList = userPage.getList();
        for (User user : userList) {
            Post condition = new Post();
            condition.setPublisher(user.getUserId());
            Long totalPostNum = postBO.getTotalCount(condition);
            user.setTotalPostNum(totalPostNum);
        }
        return userPage;
    }

    /** 
     * @see com.std.forum.ao.IUserAO#getDetailUser(com.std.forum.dto.req.XN805056Req)
     */
    @Override
    public Object getDetailUser(String tokenId, String userId) {
        XN805056Res res = userBO.getDetailUser(tokenId, userId);
        Post condition = new Post();
        condition.setPublisher(res.getUserId());
        Long totalPostNum = postBO.getTotalCount(condition);
        res.setTotalPostNum(totalPostNum);
        return res;
    }

    /** 
     * @see com.std.forum.ao.IUserAO#doSignToday(com.std.forum.dto.req.XN610903Req)
     */
    @Override
    public void doSignToday(String userId, String location) {
        XN805056Res res = userBO.getDetailUser(userId, userId);
        Long amount = ruleBO.getRuleByCondition(ERuleKind.JF, ERuleType.QD,
            res.getLevel());
        if (amount == 0L) {
            amount = ruleBO.getRuleByCondition(ERuleKind.JF, ERuleType.QD);
        }
        userBO.doSign(userId, location, amount);

    }
}
