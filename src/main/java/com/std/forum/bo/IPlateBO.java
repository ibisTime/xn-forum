/**
 * @Title IPlateBO.java 
 * @Package com.std.forum.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午1:21:32 
 * @version V1.0   
 */
package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Plate;

/** 
 * 板块
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:21:32 
 * @history:
 */
public interface IPlateBO extends IPaginableBO<Plate> {

    /**
     * 判断名称是否存在
     * @param code
     * @param name
     * @param siteCode 
     * @create: 2016年9月27日 下午8:39:03 xieyj
     * @history:
     */
    public void isExistPlate(String code, String name, String siteCode);

    public String savePlate(Plate data);

    public int refreshPlate(Plate data);

    public Plate getPlate(String code);

    public List<Plate> queryPlateList(Plate condition);
}
