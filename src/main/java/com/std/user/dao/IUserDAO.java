/**
 * @Title IUserDAO.java 
 * @Package com.ibis.pz 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 上午10:22:02 
 * @version V1.0   
 */
package com.std.user.dao;

import com.std.user.dao.base.IBaseDAO;
import com.std.user.domain.User;

/** 
 * @author: miyb 
 * @since: 2015-2-6 上午10:22:02 
 * @history:
 */
public interface IUserDAO extends IBaseDAO<User> {
    String NAMESPACE = IUserDAO.class.getName().concat(".");

    /**
     * 代注册
     * @param user
     * @return 
     * @create: 2015年11月10日 下午2:18:42 myb858
     * @history:
     */
    public int insertRen(User data);

    /** 
     * 实名认证
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateIdentity(User data);

    /** 
     * 设置交易密码
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateTradePwd(User data);

    /** 
     * 设置登陆密码
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateLoginPwd(User data);

    /** 
     * 更新手机号
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateMobile(User data);

    /**
     * 更新状态
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:20:18 myb858
     * @history:
     */
    public int updateStatus(User data);

    /**
     * 更新角色
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:20:31 myb858
     * @history:
     */
    public int updateRole(User data);

}
