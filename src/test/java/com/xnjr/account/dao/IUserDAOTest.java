/**
 * @Title IUserDAOTest.java 
 * @Package com.ibis.pz 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 下午2:13:30 
 * @version V1.0   
 */
package com.xnjr.account.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByType;

import com.std.user.common.MD5Util;
import com.std.user.common.PwdUtil;
import com.std.user.core.OrderNoGenerater;
import com.std.user.dao.IUserDAO;
import com.std.user.domain.User;
import com.std.user.enums.EUserKind;
import com.std.user.enums.EUserStatus;
import com.xnjr.account.base.ADAOTest;

/** 
 * @author: miyb 
 * @since: 2015-2-6 下午2:13:30 
 * @history:
 */
public class IUserDAOTest extends ADAOTest {
    @SpringBeanByType
    private IUserDAO userDao;

    @Test
    public void insertRen() {
        User user = new User();
        String userId = OrderNoGenerater.generate("U");

        user.setUserId(userId);
        user.setLoginName("13958092437");
        user.setLoginPwd(MD5Util.md5("123456"));
        user.setLoginPwdStrength(PwdUtil.calculateSecurityLevel("123456"));
        user.setKind(EUserKind.F1.getCode());

        user.setLevel("0");
        user.setUserReferee(userId);
        user.setMobile("13958092437");
        user.setIdKind("1");
        user.setIdNo("56789098765567890");
        user.setRealName("myb");
        user.setTradePwd(MD5Util.md5("123456"));
        user.setTradePwdStrength(PwdUtil.calculateSecurityLevel("123456"));
        user.setStatus(EUserStatus.NORMAL.getCode());// 0正常;1程序锁定;2人工锁定
        user.setUpdater(userId);

        user.setUpdateDatetime(new Date());
        user.setRemark(EUserKind.F1.getValue());
        int lineNum = userDao.insertRen(user);
        logger.info("insert : {}", lineNum);
    }

    @Test
    public void updateIdentity() {
        User data = new User();
        data.setUserId("1");
        data.setIdKind("1");
        data.setIdNo("330");
        data.setRealName("宓永宝");
        int lineNum = userDao.updateIdentity(data);
        logger.info("updateIdentity : {}", lineNum);
    }

    @Test
    public void updateTradePwd() {
        User data = new User();
        data.setUserId("1");
        data.setTradePwd(MD5Util.md5("123456"));
        int lineNum = userDao.updateTradePwd(data);
        logger.info("updateTradePwd : {}", lineNum);
    }

    @Test
    public void updateLoginPwd() {
        User data = new User();
        data.setUserId("1");
        data.setLoginPwd(MD5Util.md5("123456"));
        int lineNum = userDao.updateLoginPwd(data);
        logger.info("updateTradePwd : {}", lineNum);
    }

    @Test
    public void select() {
        User data = new User();
        data.setUserId("1");
        data = userDao.select(data);
        logger.info("select : {}", data);
    }

    @Test
    public void selectTotalCount() {
        User data = new User();
        data.setUserId("1");
        long id = userDao.selectTotalCount(data);
        logger.info("selectTotalCount : {}", id);
    }

    @Test
    public void selectList() {
        User data = new User();
        data.setMobile("18767101900");
        data.setLoginPwd("c33367701511b4f6020ec61ded352059");
        List<User> dataList = userDao.selectList(data);
        logger.info("selectList : {}", dataList);
    }

    @Test
    public void selectPage() {
        User data = new User();
        data.setMobile("13958092437");
        List<User> dataList = userDao.selectList(data, 1, 1);
        logger.info("selectPage : {}", dataList);
    }
}
