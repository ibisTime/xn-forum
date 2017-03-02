/**
 * @Title IAO.java 
 * @Package com.std.forum.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午1:59:47 
 * @version V1.0   
 */
package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Plate;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:59:47 
 * @history:
 */
public interface IPlateAO {
    String DEFAULT_ORDER_COLUMN = "code";

    public String addPlate(Plate data);

    public void editPlate(Plate data);

    public Paginable<Plate> queryPlatePage(int start, int limit, Plate condition);

    public List<Plate> queryPlateList(Plate condition);

    public Plate doGetPlate(String code);

    /**
     * 初始化平台拥有的分类和板块
     * @param companyCode
     * @param userId 
     * @create: 2017年3月1日 下午5:42:58 xieyj
     * @history:
     */
    public void initPlatPlate(String companyCode, String userId);
}
