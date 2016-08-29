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

    public int editPlate(Plate data);

    public Paginable<Plate> queryPlatePage(int start, int limit, Plate condition);

    public List<Plate> queryPlateList(Plate condition);

    public Plate doGetPlate(String code);
}
