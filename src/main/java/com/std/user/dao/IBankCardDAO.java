package com.std.user.dao;

import com.std.user.dao.base.IBaseDAO;
import com.std.user.domain.BankCard;

/**
 * @author: xieyj 
 * @since: 2015-3-7 下午2:01:11 
 * @history:
 */
public interface IBankCardDAO extends IBaseDAO<BankCard> {
    String NAMESPACE = IBankCardDAO.class.getName().concat(".");

    /**
     * 更新银行卡
     */
    public int update(BankCard data);
}
