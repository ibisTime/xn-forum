package com.std.user.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.user.dao.IBankCardDAO;
import com.std.user.dao.base.support.AMybatisTemplate;
import com.std.user.domain.BankCard;

/**
 * @author: xieyj 
 * @since: 2015-3-7 下午3:20:16 
 * @history:
 */
@Repository("bankCardDAOImpl")
public class BankCardDAOImpl extends AMybatisTemplate implements IBankCardDAO {

    /**
     * @see com.ibis.pz.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(BankCard data) {
        return super.insert(NAMESPACE.concat("insert_bankcard"), data);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(BankCard data) {
        return super.delete(NAMESPACE.concat("delete_bankcard"), data);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public BankCard select(BankCard condition) {
        return (BankCard) super.select(NAMESPACE.concat("select_bankcard"),
            condition, BankCard.class);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public long selectTotalCount(BankCard condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_bankcard_count"), condition);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<BankCard> selectList(BankCard condition) {
        return super.selectList(NAMESPACE.concat("select_bankcard"), condition,
            BankCard.class);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<BankCard> selectList(BankCard condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bankcard"), start,
            count, condition, BankCard.class);
    }

    /**
     * 
     * @see com.xnjr.account.dao.ibis.pz.IBankCardDAO#update()
     */
    @Override
    public int update(BankCard data) {
        return super.update(NAMESPACE.concat("update_bankcard"), data);
    }

}
