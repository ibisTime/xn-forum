package com.std.user.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.std.user.bo.IAccountBO;

@Component
public class AccountBOImpl implements IAccountBO {
    static Logger logger = Logger.getLogger(AccountBOImpl.class);

    @Override
    public String distributeAccount(String userId, String realName,
            String currency) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void refreshRealName(String userId, String realName) {
        // TODO Auto-generated method stub

    }

}
