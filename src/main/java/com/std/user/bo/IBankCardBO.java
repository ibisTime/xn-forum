/**
 * @Title IBankcardBO.java 
 * @Package com.ibis.pz.user 
 * @Description 
 * @author luoqi  
 * @date 2015年3月8日 上午11:45:48 
 * @version V1.0   
 */
package com.std.user.bo;

import java.util.List;

import com.std.user.bo.base.IPaginableBO;
import com.std.user.domain.BankCard;

/** 
 * @author: luoqi 
 * @since: 2015年3月8日 上午11:45:48 
 * @history:
 */
public interface IBankCardBO extends IPaginableBO<BankCard> {
    public boolean isBankCardExist(String code);

    public String saveBankCard(String userId, String realName, String bankCode,
            String bankName, String subbranch, String bankCardNo,
            String bindMobile, String updater, String remark);

    public void removeBankCard(String code);

    public void refreshBankCard(String code, String bankCode, String bankName,
            String subbranch, String bankCardNo, String bindMobile,
            String updater, String remark);

    public BankCard getBankCard(String code);

    public List<BankCard> queryBankCardList(String userId);

}
