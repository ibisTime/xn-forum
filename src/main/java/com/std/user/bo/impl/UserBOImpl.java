/**
 * @Title UserBOImpl.java 
 * @Package com.ibis.pz.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-7 上午9:21:25 
 * @version V1.0   
 */
package com.std.user.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.user.bo.IUserBO;
import com.std.user.bo.base.PaginableBOImpl;
import com.std.user.common.MD5Util;
import com.std.user.common.PhoneUtil;
import com.std.user.common.PwdUtil;
import com.std.user.core.OrderNoGenerater;
import com.std.user.dao.IUserDAO;
import com.std.user.domain.User;
import com.std.user.enums.EUserKind;
import com.std.user.enums.EUserStatus;
import com.std.user.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2015-3-7 上午9:21:25 
 * @history:
 */
@Component
public class UserBOImpl extends PaginableBOImpl<User> implements IUserBO {
    @Autowired
    private IUserDAO userDAO;

    /**
     * @see com.ibis.pz.user.IUserBO#refreshIdentity(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int refreshIdentity(String userId, String realName, String idKind,
            String idNo) {
        User data = new User();
        data.setUserId(userId);
        data.setRealName(realName);
        data.setIdKind(idKind);
        data.setIdNo(idNo);
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getUserId())) {
            count = userDAO.updateIdentity(data);
        }
        return count;
    }

    @Override
    public int refreshRealName(String userId, String realName) {
        User data = new User();
        data.setUserId(userId);
        data.setRealName(realName);
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getUserId())) {
            count = userDAO.updateRealName(data);
        }
        return count;
    }

    @Override
    public int refreshTradePwd(String userId, String tradePwd,
            String tradePwdStrength) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            User data = new User();
            data.setUserId(userId);
            data.setTradePwd(MD5Util.md5(tradePwd));
            data.setTradePwdStrength(tradePwdStrength);
            count = userDAO.updateTradePwd(data);
        }
        return count;
    }

    /** 
     * @see com.ibis.pz.user.IUserBO#getUser(java.lang.String)
     */
    @Override
    public User getUser(String userId) {
        User data = null;
        if (StringUtils.isNotBlank(userId)) {
            User condition = new User();
            condition.setUserId(userId);
            data = userDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.ibis.pz.user.IUserBO#getUserByMobile(java.lang.String)
     */
    @Override
    public User getUserByMobile(String mobile) {
        User data = null;
        if (StringUtils.isNotBlank(mobile)) {
            User condition = new User();
            condition.setMobile(mobile);
            List<User> list = userDAO.selectList(condition);
            if (list != null && list.size() > 1) {
                throw new BizException("li01006", "手机号重复");
            }
            if (CollectionUtils.isNotEmpty(list)) {
                data = list.get(0);
            }
        }
        return data;
    }

    /** 
     * @see com.ibis.pz.user.IUserBO#queryUserList(com.User.pz.domain.UserDO)
     */
    @Override
    public List<User> queryUserList(User data) {
        return userDAO.selectList(data);
    }

    /**
     * 
     * @see com.ibis.pz.user.IUserBO#refreshLoginPwd(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int refreshLoginPwd(String userId, String loginPwd,
            String loginPwdStrength) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            User data = new User();
            data.setUserId(userId);
            data.setLoginPwd(loginPwd);
            data.setLoginPwdStrength(loginPwdStrength);
            count = userDAO.updateLoginPwd(data);
        }
        return count;
    }

    @Override
    public int refreshMobile(String userId, String mobile) {
        // 手机号校验
        isMobileExist(mobile);
        User data = new User();
        data.setUserId(userId);
        data.setMobile(mobile);
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getUserId())) {
            count = userDAO.updateMobile(data);
        }
        return count;
    }

    /** 
     * @see com.ibis.pz.user.IUserBO#isMobileExist(java.lang.String)
     */
    @Override
    public void isMobileExist(String mobile) {
        // 判断格式
        PhoneUtil.checkMobile(mobile);
        User condition = new User();
        condition.setMobile(mobile);
        long count = getTotalCount(condition);
        if (count > 0) {
            throw new BizException("li01003", "手机号已经存在");
        }
    }

    /** 
     * @see com.std.user.bo.IUserBO#checkUserReferee(java.lang.String)
     */
    @Override
    public void checkUserReferee(String userReferee) {
        if (StringUtils.isNotBlank(userReferee)) {
            // 判断格式
            PhoneUtil.checkMobile(userReferee, "推荐人");
            User condition = new User();
            condition.setMobile(userReferee);
            long count = getTotalCount(condition);
            if (count <= 0) {
                throw new BizException("li01003", "推荐人不存在");
            }
        }
    }

    @Override
    public String doRegister(String mobile, String loginPwd,
            String loginPwdStrength, String userReferee) {
        String userId = null;
        if (StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(loginPwd)
                && StringUtils.isNotBlank(loginPwdStrength)) {
            User user = new User();
            userId = OrderNoGenerater.generate("U");
            user.setUserId(userId);
            user.setLoginName(mobile);
            user.setLoginPwd(MD5Util.md5(loginPwd));
            user.setLoginPwdStrength(loginPwdStrength);
            user.setKind(EUserKind.F1.getCode());

            user.setLevel("0");
            user.setUserReferee(userReferee);
            user.setMobile(mobile);
            user.setStatus(EUserStatus.NORMAL.getCode());// 0正常;1程序锁定;2人工锁定
            user.setUpdater(userId);

            user.setUpdateDatetime(new Date());
            user.setRemark(EUserKind.F1.getValue());
            userDAO.insert(user);
        }
        return userId;
    }

    @Override
    public void checkTradePwd(String userId, String tradePwd) {
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(tradePwd)) {
            User condition = new User();
            condition.setUserId(userId);
            condition.setTradePwd(MD5Util.md5(tradePwd));
            long count = this.getTotalCount(condition);
            if (count != 1) {
                throw new BizException("jd00001", "交易密码错误");
            }
        } else {
            throw new BizException("jd00001", "交易密码错误");
        }
    }

    @Override
    public void checkLoginPwd(String userId, String loginPwd) {
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(loginPwd)) {
            User condition = new User();
            condition.setUserId(userId);
            condition.setLoginPwd(MD5Util.md5(loginPwd));
            long count = this.getTotalCount(condition);
            if (count != 1) {
                throw new BizException("jd00001", "原登录密码错误");
            }
        } else {
            throw new BizException("jd00001", "原登录密码错误");
        }

    }

    @Override
    public String doAddUser(String mobile, String loginPsd, String userReferee,
            String realName, String idKind, String idNo, String tradePsd,
            String kind, String remark, String updater) {
        String userId = null;
        if (StringUtils.isNotBlank(mobile)) {
            User user = new User();
            userId = OrderNoGenerater.generate("U");

            user.setUserId(userId);
            user.setLoginName(mobile);
            user.setLoginPwd(MD5Util.md5(loginPsd));
            user.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPsd));
            user.setKind(kind);

            user.setLevel("0");
            user.setUserReferee(userReferee);
            user.setMobile(mobile);
            user.setIdKind(idKind);
            user.setIdNo(idNo);

            user.setRealName(realName);
            user.setTradePwd(MD5Util.md5(tradePsd));
            user.setTradePwdStrength(PwdUtil.calculateSecurityLevel(tradePsd));
            user.setStatus(EUserStatus.NORMAL.getCode());// 0正常;1程序锁定;2人工锁定
            user.setUpdater(updater);

            user.setUpdateDatetime(new Date());
            user.setRemark(remark);
            userDAO.insertRen(user);
        }
        return userId;
    }

    @Override
    public void refreshStatus(String userId, EUserStatus status,
            String updater, String remark) {
        if (StringUtils.isNotBlank(userId)) {
            User data = new User();
            data.setUserId(userId);
            data.setStatus(status.getCode());
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            userDAO.updateStatus(data);
        }

    }

    @Override
    public void refreshRole(String userId, String roleCode, String updater,
            String remark) {
        if (StringUtils.isNotBlank(userId)) {
            User data = new User();
            data.setUserId(userId);
            data.setRoleCode(roleCode);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            userDAO.updateRole(data);
        }

    }
}
