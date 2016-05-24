package com.xnjr.account.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByType;

import com.std.user.dao.ISYSMenuDAO;
import com.std.user.domain.SYSMenu;
import com.xnjr.account.base.ADAOTest;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月16日 下午6:52:25 
 * @history:
 */
public class ISYSMenuDAOTest extends ADAOTest {
    @SpringBeanByType
    private ISYSMenuDAO sysMenuDao;

    @Test
    public void insert() {
        SYSMenu data = new SYSMenu();
        data.setCode("1000");
        data.setName("股票配资");
        data.setType("2");
        data.setOrderNo("1");
        data.setUrl("http://www.baidu.com/");
        data.setUpdater("谢");
        data.setUpdateDatetime(new Date());
        data.setParentCode("");
        data.setRemark("新建测试");
        data.setKind("1");
        int lineNum = sysMenuDao.insert(data);
        logger.info("insert : {}", lineNum);
    }

    @Test
    public void delete() {
        SYSMenu data = new SYSMenu();
        data.setCode("1000");
        int lineNum = sysMenuDao.delete(data);
        logger.info("delete : {}", lineNum);
    }

    @Test
    public void select() {
        SYSMenu data = new SYSMenu();
        data.setCode("1000");
        data = sysMenuDao.select(data);
        logger.info("select : {}", data);
    }

    @Test
    public void selectTotalCount() {
        SYSMenu data = new SYSMenu();
        data.setCode("1000");

        long id = sysMenuDao.selectTotalCount(data);
        logger.info("selectTotalCount : {}", id);
    }

    @Test
    public void selectList() {
        SYSMenu data = new SYSMenu();
        data.setCode("1000");

        List<SYSMenu> dataList = sysMenuDao.selectList(data);
        logger.info("selectList : {}", dataList);
    }

    @Test
    public void selectPage() {
        SYSMenu data = new SYSMenu();
        data.setCode("1000");

        List<SYSMenu> dataList = sysMenuDao.selectList(data, 0, 1);
        logger.info("selectPage : {}", dataList);
    }
}
