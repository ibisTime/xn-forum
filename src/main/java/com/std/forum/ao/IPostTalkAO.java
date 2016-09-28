package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.PostTalk;

/** 
 * 点赞/收藏/打赏
 * @author: zuixian 
 * @since: 2016年9月19日 下午2:43:03 
 * @history:
 */
public interface IPostTalkAO {

    String DEFAULT_ORDER_COLUMN = "code";

    /** 
     * 进行【点赞/收藏】操作或取消【点赞/收藏】操作
     * @param data
     * @return 
     * @create: 2016年9月19日 下午2:49:22 zuixian
     * @history: 
     */
    public int doPostTalk(String postCode, String userId, String type);

    /**
     * 打赏帖子
     * @param postCode
     * @param userId
     * @param amount
     * @return 
     * @create: 2016年9月28日 下午3:14:30 xieyj
     * @history:
     */
    public int doPostTalkByAmount(String postCode, String userId, Long amount);

    /** 
     * 查询单一类型的记录
     * @param postCode
     * @param type
     * @return 
     * @create: 2016年9月19日 下午2:50:14 zuixian
     * @history: 
     */
    public List<PostTalk> queryPostTalkSingleList(String postCode, String type);

    /** 
     * 列表查询
     * @param condition
     * @return 
     * @create: 2016年9月26日 下午3:55:56 zuixian
     * @history: 
     */
    public List<PostTalk> queryPostTalkList(PostTalk condition);

    /** 
     * 分页查询
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年9月26日 下午3:56:21 zuixian
     * @history: 
     */
    public Paginable<PostTalk> queryPostTalkPage(int start, int limit,
            PostTalk condition);

    /** 
     * 详情查询
     * @param code
     * @return 
     * @create: 2016年9月26日 下午3:56:29 zuixian
     * @history: 
     */
    public PostTalk getPostTalk(String postCode, String talker);
}
