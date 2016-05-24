/**
 * @Title IUserBankCardAO.java 
 * @Package com.ibis.pz.user 
 * @Description 
 * @author miyb  
 * @date 2015-3-8 上午10:48:42 
 * @version V1.0   
 */
package com.std.user.ao;

import java.util.List;

import com.std.user.domain.BankCard;

/** 
 * @author: miyb 
 * @since: 2015-3-8 上午10:48:42 
 * @history:
 */
public interface IBankCardAO {

    public String doBindBandCard(String userId, String bankCode,
            String bankName, String subbranch, String bankCardNo,
            String bindMobile, String updater, String remark);

    public void dropBankCard(String code);

    public void doRebindBankCard(String code, String bankCode, String bankName,
            String subbranch, String bankCardNo, String bindMobile,
            String updater, String remark);

    public List<BankCard> queryBankCardList(String userId);

}
