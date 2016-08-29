package com.xnjr.forum.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByType;

import com.std.forum.dao.ISiteDAO;
import com.std.forum.domain.Site;
import com.std.forum.enums.EBoolean;
import com.xnjr.forum.base.ADAOTest;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 上午11:01:50 
 * @history:
 */
public class SiteDAOTest extends ADAOTest {
    @SpringBeanByType
    private ISiteDAO siteDAO;

    @Test
    public void insert() {
        Site data = new Site();
        data.setCode("ZD000000000001");
        data.setName("杭州在线");
        data.setLeader("杭州负责人");
        data.setContacts("18767101909");
        data.setAddress("杭州");
        data.setIsHot(EBoolean.YES.getCode());
        data.setUpdater("admin");
        data.setUpdateDatetime(new Date());
        data.setRemark("备注");
        int lineNum = siteDAO.insert(data);
        logger.info("insert : {}", lineNum);
    }

    @Test
    public void select() {
        Site data = new Site();
        data.setCode("ZD000000000001");
        data.setName("杭州在线");
        data.setLeader("杭州负责人");
        data.setIsHot(EBoolean.YES.getCode());
        data = siteDAO.select(data);
        logger.info("select : {}", data);
    }

    @Test
    public void selectTotalCount() {
        Site data = new Site();
        data.setCode("ZD000000000001");
        data.setName("杭州在线");
        data.setLeader("杭州负责人");
        data.setIsHot(EBoolean.YES.getCode());
        long id = siteDAO.selectTotalCount(data);
        logger.info("selectTotalCount : {}", id);
    }

    @Test
    public void selectList() {
        Site data = new Site();
        data.setCode("ZD000000000001");
        data.setName("杭州在线");
        data.setLeader("杭州负责人");
        data.setIsHot(EBoolean.YES.getCode());
        List<Site> dataList = siteDAO.selectList(data);
        logger.info("selectList : {}", dataList);
    }

    @Test
    public void selectPage() {
        Site data = new Site();
        data.setCode("ZD000000000001");
        data.setName("杭州在线");
        data.setLeader("杭州负责人");
        data.setIsHot(EBoolean.YES.getCode());
        List<Site> dataList = siteDAO.selectList(data, 0, 1);
        logger.info("selectPage : {}", dataList);
    }

    @Test
    public void update() {
        Site data = new Site();
        data.setCode("ZD000000000001");
        data.setName("杭州在线1");
        data.setLeader("杭州负责人1");
        data.setContacts("18767101908");
        data.setAddress("杭州");
        data.setIsHot(EBoolean.YES.getCode());
        data.setUpdater("admin");
        data.setUpdateDatetime(new Date());
        data.setRemark("备注");
        int count = siteDAO.update(data);
        logger.info("update : {}", count);
    }
}
