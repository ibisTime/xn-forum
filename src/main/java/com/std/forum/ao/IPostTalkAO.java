package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.PostTalk;

/**
 * 点赞/收藏/打赏/阅读/帖子举报/评论举报
 * @author: xieyj 
 * @since: 2016年10月24日 下午5:05:53 
 * @history:
 */
public interface IPostTalkAO {

    String DEFAULT_ORDER_COLUMN = "code";

    /*
     * 点赞/收藏设置和取消
     */
    public void doPostTalk(String postCode, String userId, String type);

    /*
     * 打赏
     */
    public void doPostTalk(String postCode, String userId, Long amount);

    /*
     * 举报帖子/评论
     */
    public void reportPost(String code, String reporter, String reportNote,
            String type);

    public Paginable<PostTalk> queryPostTalkPage(int start, int limit,
            PostTalk condition);

    public List<PostTalk> queryPostTalkList(PostTalk condition);
}
