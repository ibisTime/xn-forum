/**
 * @Title IUserAO.java 
 * @Package com.ibis.pz.user 
 * @Description 
 * @author miyb  
 * @date 2015-3-8 上午10:48:42 
 * @version V1.0   
 */
package com.std.user.ao;

import java.util.List;

import com.std.user.bo.base.Paginable;
import com.std.user.domain.User;

/** 
 * @author: miyb 
 * @since: 2015-3-8 上午10:48:42 
 * @history:
 */
public interface IUserAO {
    String DEFAULT_ORDER_COLUMN = "user_id";

    /**
     * 检查手机号是否存在
     * @param mobile 
     * @create: 2016年1月21日 下午1:36:39 myb858
     * @history:
     */
    public void doCheckMobile(String mobile);

    /**
     * 注册
     * @param mobile
     * @param loginPwd
     * @param loginPwdStrength
     * @param userReferee
     * @param smsCaptcha
     * @return 
     * @create: 2016年5月24日 下午5:05:26 myb858
     * @history:
     */
    public String doRegister(String mobile, String loginPwd,
            String loginPwdStrength, String userReferee, String smsCaptcha);

    /**
     * 代注册
     * @param mobile
     * @param idKind
     * @param idNo
     * @param realName
     * @param userReferee
     * @param updater
     * @param remark
     * @param kind
     * @return 
     * @create: 2016年5月24日 下午5:03:53 myb858
     * @history:
     */
    public String doAddUser(String mobile, String idKind, String idNo,
            String realName, String userReferee, String updater, String remark,
            String kind);

    /**
     * 代注册
     * @param mobile
     * @param realName
     * @param userReferee
     * @param updater
     * @param remark
     * @param kind
     * @return 
     * @create: 2016年6月1日 上午11:38:40 xieyj
     * @history:
     */
    public String doAddUser(String mobile, String realName, String userReferee,
            String updater, String remark, String kind);

    /**
     * 用户登陆
     * @param loginName
     * @param loginPwd
     * @param kind
     * @return 
     * @create: 2016年6月11日 下午9:40:18 xieyj
     * @history:
     */
    public String doLogin(String loginName, String loginPwd, String kind);

    /**
     * 实名认证
     * @param userId
     * @param idKind
     * @param idNo
     * @param realName 
     * @create: 2016年5月24日 下午5:10:00 myb858
     * @history:
     */
    public void doIdentify(String userId, String idKind, String idNo,
            String realName);

    /**
     * 修改真实姓名
     * @param userId
     * @param realName 
     * @create: 2016年6月1日 下午12:18:03 xieyj
     * @history:
     */
    public void doEditRealName(String userId, String realName);

    /**
     * 设置交易密码
     * @param userId
     * @param tradePwd
     * @param tradePwdStrength
     * @param smsCaptcha 
     * @create: 2016年5月24日 下午5:16:06 myb858
     * @history:
     */
    public void doSetTradePwd(String userId, String tradePwd,
            String tradePwdStrength, String smsCaptcha);

    /**
     * 实名认证+交易密码设置
     * @param userId
     * @param idKind
     * @param idNo
     * @param realName
     * @param tradePwd
     * @param tradePwdStrength
     * @param smsCaptcha 
     * @create: 2016年5月24日 下午5:21:15 myb858
     * @history:
     */
    public void doIdentifySetTradePwd(String userId, String idKind,
            String idNo, String realName, String tradePwd,
            String tradePwdStrength, String smsCaptcha);

    /**
     * 更换手机号
     * @param userId
     * @param newMobile
     * @param smsCaptcha
     * @param tradePwd
     * @return 
     * @create: 2015年9月17日 下午12:42:33 myb858
     * @history:
     */
    public void doChangeMoblie(String userId, String newMobile,
            String smsCaptcha, String tradePwd);

    /**
     * 找回登录密码
     * @param mobile
     * @param smsCaptcha
     * @param newLoginPwd
     * @param loginPwdStrength
     * @return 
     * @create: 2016年5月24日 下午5:25:44 myb858
     * @history:
     */
    public void doFindLoginPwd(String mobile, String smsCaptcha,
            String newLoginPwd, String loginPwdStrength);

    /**
     * 重置登录密码
     * @param userId
     * @param oldLoginPwd
     * @param newLoginPwd
     * @param loginPwdStrength
     * @return 
     * @create: 2016年5月24日 下午7:05:18 myb858
     * @history:
     */
    public void doResetLoginPwd(String userId, String oldLoginPwd,
            String newLoginPwd, String loginPwdStrength);

    /**
     * 找回交易密码
     * @param userId
     * @param newTradePwd
     * @param tradePwdStrength
     * @param smsCaptcha
     * @param idKind
     * @param idNo
     * @return 
     * @create: 2016年5月24日 下午5:30:42 myb858
     * @history:
     */
    public void doFindTradePwd(String userId, String newTradePwd,
            String tradePwdStrength, String smsCaptcha, String idKind,
            String idNo);

    /**
     * 找回交易密码(无需实名认证)
     * @param userId
     * @param newTradePwd
     * @param tradePwdStrength
     * @param smsCaptcha
     * @param idKind
     * @param idNo
     * @return 
     * @create: 2016年5月24日 下午5:30:42 myb858
     * @history:
     */
    public void doFindTradePwd(String userId, String newTradePwd,
            String tradePwdStrength, String smsCaptcha);

    /**
     * 重置交易密码
     * @param userId
     * @param oldTradePwd
     * @param newTradePwd
     * @param tradePwdStrength
     * @return 
     * @create: 2016年5月24日 下午7:05:39 myb858
     * @history:
     */
    public void doResetTradePwd(String userId, String oldTradePwd,
            String newTradePwd, String tradePwdStrength);

    /**
     * 注销/激活用户
     * @param userId
     * @param toStatus
     * @param updater
     * @param remark
     * @return 
     * @create: 2016年5月24日 下午5:46:50 myb858
     * @history:
     */
    public void doStatusUser(String userId, String toStatus, String updater,
            String remark);

    /**
     * 设置角色
     * @param userId
     * @param roleCode
     * @param updater
     * @param remark
     * @return 
     * @create: 2016年5月24日 下午5:50:16 myb858
     * @history:
     */
    public void doRoleUser(String userId, String roleCode, String updater,
            String remark);

    /** 
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015-6-7 上午10:04:12 miyb
     * @history: 
     */
    public Paginable<User> queryUserPage(int start, int limit, User condition);

    /**
     * 
     * @param condition
     * @return 
     * @create: 2015年10月28日 下午2:41:48 myb858
     * @history:
     */
    public List<User> queryUserList(User condition);

    /**
     * 查询用户的详细信息
     * @param userId
     * @create: 2014-12-10 下午7:37:18 miyb
     * @history:
     */
    public User doGetUser(String userId);

    /**
     * 校验交易密码
     * @param userId
     * @param tradePwd
     * @return 
     * @create: 2015年11月10日 上午9:16:42 myb858
     * @history:
     */
    public void checkTradePwd(String userId, String tradePwd);

    /**
     * 发送短信
     * @param userId
     * @param content 
     * @create: 2016年5月24日 下午6:46:07 myb858
     * @history:
     */
    public void sendAppSms(String userId, String content);

}
