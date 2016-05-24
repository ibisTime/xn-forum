/**
 * @Title BankCardAOImpl.java 
 * @Package com.ibis.pz.user.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-8 上午10:52:06 
 * @version V1.0   
 */
package com.std.user.ao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.user.ao.IBankCardAO;
import com.std.user.bo.IBankCardBO;
import com.std.user.bo.IUserBO;
import com.std.user.domain.BankCard;
import com.std.user.domain.User;
import com.std.user.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2015-3-8 上午10:52:06 
 * @history:
 */
@Service
public class BankCardAOImpl implements IBankCardAO {
    @Autowired
    IUserBO userBO;

    @Autowired
    IBankCardBO bankCardBO;

    @Override
    @Transactional
    public String doBindBandCard(String userId, String bankCode,
            String bankName, String subbranch, String bankCardNo,
            String bindMobile, String updater, String remark) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn702000", "用户不存在");
        }
        if (StringUtils.isBlank(user.getRealName())) {
            throw new BizException("xn702000", "请先实名认证");
        }
        return bankCardBO.saveBankCard(user.getUserId(), user.getRealName(),
            bankCode, bankName, subbranch, bankCardNo, bindMobile, updater,
            remark);

    }

    @Override
    public void dropBankCard(String code) {
        if (!bankCardBO.isBankCardExist(code)) {
            throw new BizException("xn702000", "删除银行卡不存在！");
        }
        bankCardBO.removeBankCard(code);

    }

    @Override
    public void doRebindBankCard(String code, String bankCode, String bankName,
            String subbranch, String bankCardNo, String bindMobile,
            String updater, String remark) {
        BankCard bankCard = bankCardBO.getBankCard(code);
        if (bankCard == null) {
            throw new BizException("xn702000", "编号不存在");
        }
        User user = userBO.getUser(bankCard.getUserId());
        if (user == null) {
            throw new BizException("xn702000", "用户不存在");
        }
        if (StringUtils.isBlank(user.getRealName())) {
            throw new BizException("xn702000", "请先实名认证");
        }

        bankCardBO.refreshBankCard(code, bankCode, bankName, subbranch,
            bankCardNo, bindMobile, updater, remark);
    }

    @Override
    public List<BankCard> queryBankCardList(String userId) {
        return bankCardBO.queryBankCardList(userId);
    }
}
