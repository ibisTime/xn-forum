//package com.xnjr.forum.dao;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Test;
//import org.unitils.spring.annotation.SpringBeanByType;
//
//import com.std.forum.dao.IPostDAO;
//import com.std.forum.domain.Post;
//import com.std.forum.enums.EBoolean;
//import com.std.forum.enums.EPostStatus;
//import com.xnjr.forum.base.ADAOTest;
//
///** 
// * @author: xieyj 
// * @since: 2016年8月29日 上午11:01:50 
// * @history:
// */
//public class PostDAOTest extends ADAOTest {
//    @SpringBeanByType
//    private IPostDAO postDAO;
//
//    @Test
//    public void insert() {
//        Post data = new Post();
//        data.setCode("TZ000000000001");
//        data.setTitle("喜迎G20");
//        data.setContent("火树银花");
//        data.setPic("www.baidu.com");
//        data.setIsHeadliness(EBoolean.NO.getCode());
//        data.setReadTime(0);
//        data.setStatus(EPostStatus.todoAPPROVE.getCode());
//        data.setPublisher("admin");
//        data.setPublishDatetime(new Date());
//        int lineNum = postDAO.insert(data);
//        logger.info("insert : {}", lineNum);
//    }
//
//    @Test
//    public void select() {
//        Post data = new Post();
//        data.setCode("TZ000000000001");
//        data.setTitle("喜迎G20");
//        data.setIsHeadlines(EBoolean.NO.getCode());
//        data.setStatus(EPostStatus.todoAPPROVE.getCode());
//        data = postDAO.select(data);
//        logger.info("select : {}", data);
//    }
//
//    @Test
//    public void selectTotalCount() {
//        Post data = new Post();
//        data.setCode("TZ000000000001");
//        data.setTitle("喜迎G20");
//        data.setIsHeadlines(EBoolean.NO.getCode());
//        data.setStatus(EPostStatus.todoAPPROVE.getCode());
//        long id = postDAO.selectTotalCount(data);
//        logger.info("selectTotalCount : {}", id);
//    }
//
//    @Test
//    public void selectList() {
//        Post data = new Post();
//        data.setCode("TZ000000000001");
//        data.setTitle("喜迎G20");
//        data.setIsHeadlines(EBoolean.NO.getCode());
//        data.setStatus(EPostStatus.todoAPPROVE.getCode());
//        List<Post> dataList = postDAO.selectList(data);
//        logger.info("selectList : {}", dataList);
//    }
//
//    @Test
//    public void selectPage() {
//        Post data = new Post();
//        data.setCode("TZ000000000001");
//        data.setTitle("喜迎G20");
//        data.setIsHeadlines(EBoolean.NO.getCode());
//        data.setStatus(EPostStatus.todoAPPROVE.getCode());
//        List<Post> dataList = postDAO.selectList(data, 0, 1);
//        logger.info("selectPage : {}", dataList);
//    }
//
//    @Test
//    public void updateApprove() {
//        Post data = new Post();
//        data.setCode("TZ000000000001");
//        data.setStatus(EPostStatus.APPROVE_YES.getCode());
//        data.setApprover("admin");
//        data.setApproveDatetime(new Date());
//        data.setApproveNote("审核通过");
//        int count = postDAO.updateApprove(data);
//        logger.info("updateApprove : {}", count);
//    }
//
//    @Test
//    public void updateAttr() {
//        Post data = new Post();
//        data.setCode("TZ000000000001");
//        data.setIsHeadlines(EBoolean.NO.getCode());
//        int count = postDAO.updateAttr(data);
//        logger.info("updateAttr : {}", count);
//    }
//
//    @Test
//    public void updateReadTime() {
//        Post data = new Post();
//        data.setCode("TZ000000000001");
//        int count = postDAO.updateReadTime(data);
//        logger.info("updateReadTime : {}", count);
//    }
// }
