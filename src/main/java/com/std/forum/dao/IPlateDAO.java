/**
 * @Title IPlateDAO.java 
 * @Package com.std.forum.dao 
 * @Description 
 * @author xieyj  
 * @date 2016年8月28日 下午9:38:49 
 * @version V1.0   
 */
package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Plate;

/** 
 * 板块DAO
 * @author: xieyj 
 * @since: 2016年8月28日 下午9:38:49 
 * @history:
 */
public interface IPlateDAO extends IBaseDAO<Plate> {
    String NAMESPACE = IPlateDAO.class.getName().concat(".");

    /**
     * 更新板块
     */
    public int update(Plate data);

}
