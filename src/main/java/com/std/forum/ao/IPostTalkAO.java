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
     * 进行【点赞/收藏/打赏】操作
     * @param data
     * @return 
     * @create: 2016年9月19日 下午2:49:22 zuixian
     * @history: 
     */
    public String doPostTalk(PostTalk data);

    /** 
     * 查询单一类型的记录
     * @param postCode
     * @param type
     * @return 
     * @create: 2016年9月19日 下午2:50:14 zuixian
     * @history: 
     */
    public List<PostTalk> queryPostTalkSingleList(String postCode, String type);

    public List<PostTalk> queryPostTalkList(PostTalk condition);

    public Paginable<PostTalk> queryPostTalkPage(int start, int limit,
            PostTalk condition);

    public PostTalk getPostTalk(String code);
}
