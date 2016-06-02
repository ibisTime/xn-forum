package com.std.user.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.std.user.bo.IAccountBO;
import com.std.user.dto.req.XN802000Req;
import com.std.user.dto.res.XN802000Res;
import com.std.user.http.BizConnecter;
import com.std.user.http.JsonUtils;

@Component
public class AccountBOImpl implements IAccountBO {
    static Logger logger = Logger.getLogger(AccountBOImpl.class);

    @Override
    public String distributeAccount(String userId, String realName,
            String currency) {
        XN802000Req req = new XN802000Req();
        req.setUserId(userId);
        req.setRealName(realName);
        req.setCurrency(currency);
        XN802000Res res = BizConnecter.getBizData("802000",
            JsonUtils.object2Json(req), XN802000Res.class);
        String accountNumber = null;
        if (res != null) {
            accountNumber = res.getAccountNumber();
        }
        return accountNumber;
    }

    @Override
    public void refreshRealName(String userId, String realName) {
        // TODO Auto-generated method stub
    }

}
