package com.std.forum.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IAccountBO;
import com.std.forum.dto.req.XN802316Req;
import com.std.forum.http.BizConnecter;
import com.std.forum.http.JsonUtils;

@Component
public class AccountBOImpl implements IAccountBO {
    static Logger logger = Logger.getLogger(AccountBOImpl.class);

    /** 
     * @see com.xnjr.mall.bo.IAccountBO#doTransferUsers(java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String)
     */
    @Override
    public void doTransferUsers(String fromUserId, String toUserId,
            String direction, Long amount, Long fee, String remark) {
        XN802316Req req = new XN802316Req();
        req.setFromUserId(fromUserId);
        req.setToUserId(toUserId);
        req.setDirection(direction);
        req.setAmount(String.valueOf(amount));
        req.setFee(String.valueOf(fee));
        req.setRemark(remark);
        BizConnecter.getBizData("802316", JsonUtils.object2Json(req),
            Object.class);
    }
}
