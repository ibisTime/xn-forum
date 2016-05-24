/**
 * @Title BankCardBOImpl.java 
 * @Package com.ibis.pz.user.impl 
 * @Description 
 * @author luoqi  
 * @date 2015年3月8日 上午11:51:56 
 * @version V1.0   
 */
package com.std.user.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.user.bo.IBankCardBO;
import com.std.user.bo.base.PaginableBOImpl;
import com.std.user.core.OrderNoGenerater;
import com.std.user.dao.IBankCardDAO;
import com.std.user.domain.BankCard;
import com.std.user.enums.EBankCardStatus;

/** 
 * @author: luoqi 
 * @since: 2015年3月8日 上午11:51:56 
 * @history:
 */
@Component
public class BankCardBOImpl extends PaginableBOImpl<BankCard> implements
        IBankCardBO {
    @Autowired
    private IBankCardDAO bankCardDAO;

    @Override
    public boolean isBankCardExist(String code) {
        BankCard condition = new BankCard();
        condition.setCode(code);
        if (bankCardDAO.selectTotalCount(condition) >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBankCard(String userId, String realName, String bankCode,
            String bankName, String subbranch, String bankCardNo,
            String bindMobile, String updater, String remark) {
        BankCard data = new BankCard();
        String code = OrderNoGenerater.generate("BC");
        data.setCode(code);
        data.setUserId(userId);
        data.setRealName(realName);
        data.setBankCode(bankCode);
        data.setBankName(bankName);

        data.setSubbranch(subbranch);
        data.setBankCardNo(bankCardNo);
        data.setBindMobile(bindMobile);
        data.setStatus(EBankCardStatus.TOCONFIRM.getCode());
        data.setUpdater(updater);

        data.setUpdateDatetime(new Date());
        data.setRemark(remark);

        bankCardDAO.insert(data);
        return code;
    }

    @Override
    public void removeBankCard(String code) {
        if (StringUtils.isNotBlank(code)) {
            BankCard condition = new BankCard();
            condition.setCode(code);
            bankCardDAO.delete(condition);
        }
    }

    @Override
    public void refreshBankCard(String code, String bankCode, String bankName,
            String subbranch, String bankCardNo, String bindMobile,
            String updater, String remark) {
        BankCard data = new BankCard();
        data.setCode(code);
        data.setBankCode(bankCode);
        data.setBankName(bankName);
        data.setSubbranch(subbranch);
        data.setBankCardNo(bankCardNo);

        data.setBindMobile(bindMobile);
        data.setStatus(EBankCardStatus.TOCONFIRM.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        bankCardDAO.update(data);

    }

    @Override
    public BankCard getBankCard(String code) {
        BankCard bankCard = null;
        if (StringUtils.isNotBlank(code)) {
            BankCard condition = new BankCard();
            condition.setCode(code);
            bankCard = bankCardDAO.select(condition);
        }
        return bankCard;
    }

    @Override
    public List<BankCard> queryBankCardList(String userId) {
        List<BankCard> list = null;
        if (StringUtils.isNotBlank(userId)) {
            BankCard condition = new BankCard();
            condition.setUserId(userId);
            list = bankCardDAO.selectList(condition);
        }
        return list;
    }

}
