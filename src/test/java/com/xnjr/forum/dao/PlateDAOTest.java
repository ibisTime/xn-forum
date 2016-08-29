package com.xnjr.forum.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByType;

import com.std.forum.dao.IPlateDAO;
import com.std.forum.domain.Plate;
import com.xnjr.forum.base.ADAOTest;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 上午11:01:50 
 * @history:
 */
public class PlateDAOTest extends ADAOTest {
    @SpringBeanByType
    private IPlateDAO plateDAO;

    @Test
    public void insert() {
        Plate data = new Plate();
        data.setCode("BK000000000001");
        data.setName("亲亲家园");
        data.setPic("www.baidu.com");
        data.setSiteCode("ZD000000000001");
        data.setUpdater("admin");
        data.setUpdateDatetime(new Date());
        data.setRemark("备注");
        int lineNum = plateDAO.insert(data);
        logger.info("insert : {}", lineNum);
    }

    @Test
    public void select() {
        Plate data = new Plate();
        data.setCode("BK000000000001");
        data.setName("亲亲家园");
        data.setSiteCode("ZD000000000001");
        data = plateDAO.select(data);
        logger.info("select : {}", data);
    }

    @Test
    public void selectTotalCount() {
        Plate data = new Plate();
        data.setCode("BK000000000001");
        data.setName("亲亲家园");
        data.setSiteCode("ZD000000000001");
        long id = plateDAO.selectTotalCount(data);
        logger.info("selectTotalCount : {}", id);
    }

    @Test
    public void selectList() {
        Plate data = new Plate();
        data.setCode("BK000000000001");
        data.setName("亲亲家园");
        data.setSiteCode("ZD000000000001");
        List<Plate> dataList = plateDAO.selectList(data);
        logger.info("selectList : {}", dataList);
    }

    @Test
    public void selectPage() {
        Plate data = new Plate();
        data.setCode("BK000000000001");
        data.setName("亲亲家园");
        data.setSiteCode("ZD000000000001");
        List<Plate> dataList = plateDAO.selectList(data, 0, 1);
        logger.info("selectPage : {}", dataList);
    }

    @Test
    public void update() {
        Plate data = new Plate();
        data.setCode("BK000000000001");
        data.setName("亲亲家园1");
        data.setPic("www.taobao.com");
        data.setSiteCode("ZD000000000001");
        data.setUpdater("admin");
        data.setUpdateDatetime(new Date());
        data.setRemark("备注1");
        int count = plateDAO.update(data);
        logger.info("update : {}", count);
    }
}
