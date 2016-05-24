package com.xnjr.account.dao;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.unitils.spring.annotation.SpringBeanByType;

import com.std.user.core.OrderNoGenerater;
import com.std.user.dao.IBankCardDAO;
import com.std.user.domain.BankCard;
import com.std.user.enums.EBankCardStatus;
import com.std.user.enums.EBankCode;
import com.xnjr.account.base.ADAOTest;

/**
 * @author: xieyj 
 * @since: 2015-3-7 下午3:04:04 
 * @history:
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IBankCardDAOTest extends ADAOTest {
    @SpringBeanByType
    private IBankCardDAO bankCardDAO;

    @Test
    public void insert() {
        BankCard data = new BankCard();
        String code = OrderNoGenerater.generate("BC");
        data.setCode(code);
        data.setUserId("userId");
        data.setRealName("realName");
        data.setBankCode("bankCode");
        data.setBankName("bankName");

        data.setSubbranch("subbranch");
        data.setBankCardNo("bankCardNo");
        data.setBindMobile("bindMobile");
        data.setStatus(EBankCardStatus.TOCONFIRM.getCode());
        data.setUpdater("updater");

        data.setUpdateDatetime(new Date());
        data.setRemark("remark");

        int lineNum = bankCardDAO.insert(data);
        logger.info("insert : {}", lineNum);
    }

    @Test
    public void delete() {
        BankCard condition = new BankCard();
        condition.setCode("BC2016052501082453189");
        int lineNum = bankCardDAO.delete(condition);
        logger.info("delete : {}", lineNum);
    }

    @Test
    public void update() {
        BankCard data = new BankCard();
        data.setCode("BC2016052501094170779");
        data.setBankCode("bCode1");
        data.setBankName("bankName1");
        data.setSubbranch("subbranch1");
        data.setBankCardNo("bankCardNo1");

        data.setBindMobile("bindMobile1");
        data.setStatus(EBankCardStatus.CONFIRM_YES.getCode());
        data.setUpdater("updater1");
        data.setUpdateDatetime(new Date());
        data.setRemark("remark1");

        int lineNum = bankCardDAO.update(data);
        logger.info("update : {}", lineNum);
    }

    @Test
    public void select() {
        BankCard data = new BankCard();
        data.setUserId("12");
        // 这里缺少一张银行信息管理表
        data.setBankCode(EBankCode.ABC.getCode());
        data.setBankName(EBankCode.ABC.getValue());
        data.setBankCardNo("111111");
        data.setStatus(EBankCardStatus.TOCONFIRM.getCode());// 0 待确认 1 验证通过
        data = bankCardDAO.select(data);
        logger.info("select : {}", data);
    }

    @Test
    public void selectTotalCount() {
        BankCard data = new BankCard();
        data.setUserId("12");
        long id = bankCardDAO.selectTotalCount(data);
        logger.info("selectTotalCount : {}", id);
    }

    @Test
    public void selectList() {
        BankCard data = new BankCard();
        data.setUserId("12");
        data.setBankCode(EBankCode.ABC.getCode());
        data.setBankName(EBankCode.ABC.getValue());
        data.setBankCardNo("111111");
        data.setStatus(EBankCardStatus.TOCONFIRM.getCode());// 0 待确认 1 验证通过
        List<BankCard> dataList = bankCardDAO.selectList(data);
        logger.info("selectList : {}", dataList);
    }

    @Test
    public void selectPage() {
        BankCard data = new BankCard();
        data.setUserId("12");
        data.setBankCode(EBankCode.ABC.getCode());
        data.setBankName(EBankCode.ABC.getValue());
        data.setBankCardNo("111111");
        data.setStatus(EBankCardStatus.TOCONFIRM.getCode());// 0 待确认 1 验证通过
        List<BankCard> dataList = bankCardDAO.selectList(data, 0, 1);
        logger.info("selectPage : {}", dataList);
    }

}
