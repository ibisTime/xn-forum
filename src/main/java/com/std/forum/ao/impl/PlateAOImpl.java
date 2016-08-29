/**
 * @Title PlateAOImpl.java 
 * @Package com.std.forum.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午2:11:00 
 * @version V1.0   
 */
package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IPlateAO;
import com.std.forum.bo.IPlateBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Plate;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午2:11:00 
 * @history:
 */
@Service
public class PlateAOImpl implements IPlateAO {
    @Autowired
    protected IPlateBO plateBO;

    /** 
     * @see com.std.forum.ao.IPlateAO#addPlate(com.std.forum.domain.Plate)
     */
    @Override
    public String addPlate(Plate data) {
        return plateBO.savePlate(data);
    }

    /** 
     * @see com.std.forum.ao.IPlateAO#editPlate(com.std.forum.domain.Plate)
     */
    @Override
    public int editPlate(Plate data) {
        return plateBO.refreshPlate(data);
    }

    /** 
     * @see com.std.forum.ao.IPlateAO#queryPlatePage(int, int, com.std.forum.domain.Plate)
     */
    @Override
    public Paginable<Plate> queryPlatePage(int start, int limit, Plate condition) {
        return plateBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.std.forum.ao.IPlateAO#queryPlateList(com.std.forum.domain.Plate)
     */
    @Override
    public List<Plate> queryPlateList(Plate condition) {
        return plateBO.queryPlateList(condition);
    }

    /** 
     * @see com.std.forum.ao.IPlateAO#doGetPlate(java.lang.String)
     */
    @Override
    public Plate doGetPlate(String code) {
        return plateBO.getPlate(code);
    }

}
