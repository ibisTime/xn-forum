/**
 * @Title PlateDAOImpl.java 
 * @Package com.std.forum.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月28日 下午9:39:55 
 * @version V1.0   
 */
package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.IPlateDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Plate;

/** 
 * @author: xieyj 
 * @since: 2016年8月28日 下午9:39:55 
 * @history:
 */
@Repository("plateDAOImpl")
public class PlateDAOImpl extends AMybatisTemplate implements IPlateDAO {

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Plate data) {
        return super.insert(NAMESPACE.concat("insert_plate"), data);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Plate data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Plate select(Plate condition) {
        return (Plate) super.select(NAMESPACE.concat("select_plate"),
            condition, Plate.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public long selectTotalCount(Plate condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_plate_count"),
            condition);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Plate> selectList(Plate condition) {
        return super.selectList(NAMESPACE.concat("select_plate"), condition,
            Plate.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Plate> selectList(Plate condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_plate"), start, count,
            condition, Plate.class);
    }

    /** 
     * @see com.std.forum.dao.IPlateDAO#update(com.std.forum.domain.Plate)
     */
    @Override
    public int update(Plate data) {
        return super.update(NAMESPACE.concat("update_plate"), data);
    }

}
