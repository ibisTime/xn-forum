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
import com.std.forum.bo.IPostBO;
import com.std.forum.bo.IPostTalkBO;
import com.std.forum.bo.ISiteBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Plate;
import com.std.forum.domain.Post;
import com.std.forum.domain.PostTalk;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午2:11:00 
 * @history:
 */
@Service
public class PlateAOImpl implements IPlateAO {
    @Autowired
    protected IPlateBO plateBO;

    @Autowired
    protected IPostTalkBO postTalkBO;

    @Autowired
    protected IPostBO postBO;

    @Autowired
    protected ISiteBO siteBO;

    /** 
     * @see com.std.forum.ao.IPlateAO#addPlate(com.std.forum.domain.Plate)
     */
    @Override
    public String addPlate(Plate data) {
        plateBO.isExistPlateName(null, data.getName(), data.getSiteCode());
        return plateBO.savePlate(data);
    }

    /** 
     * @see com.std.forum.ao.IPlateAO#editPlate(com.std.forum.domain.Plate)
     */
    @Override
    public int editPlate(Plate data) {
        // 获取板块信息
        Plate plate = plateBO.getPlate(data.getCode());
        // 判断板块名称是否存在
        plateBO.isExistPlateName(data.getCode(), data.getName(),
            plate.getSiteCode());
        return plateBO.refreshPlate(data);
    }

    /** 
     * @see com.std.forum.ao.IPlateAO#queryPlatePage(int, int, com.std.forum.domain.Plate)
     */
    @Override
    public Paginable<Plate> queryPlatePage(int start, int limit, Plate condition) {
        Paginable<Plate> platePage = plateBO.getPaginable(start, limit,
            condition);
        List<Plate> plateList = platePage.getList();
        totalPostToPlateList(plateList);
        return platePage;
    }

    /** 
     * @see com.std.forum.ao.IPlateAO#queryPlateList(com.std.forum.domain.Plate)
     */
    @Override
    public List<Plate> queryPlateList(Plate condition) {
        List<Plate> plateList = plateBO.queryPlateList(condition);
        totalPostToPlateList(plateList);
        return plateList;
    }

    /** 
     * @see com.std.forum.ao.IPlateAO#doGetPlate(java.lang.String)
     */
    @Override
    public Plate doGetPlate(String code) {
        return plateBO.getPlate(code);
    }

    private void totalPostToPlateList(List<Plate> plateList) {
        for (Plate plate : plateList) {
            totalPostToPlate(plate);
        }
    }

    private void totalPostToPlate(Plate plate) {
        PostTalk ptCondition = new PostTalk();
        ptCondition.setPlateCode(plate.getCode());
        Post pCondition = new Post();
        pCondition.setPlateCode(plate.getCode());
        long pCount = postBO.getPostNum(pCondition);
        long ptCount = postTalkBO.getPersonCount(ptCondition);
        plate.setPostCount(String.valueOf(pCount));
        plate.setPersonCount(String.valueOf(ptCount));
    }
}
