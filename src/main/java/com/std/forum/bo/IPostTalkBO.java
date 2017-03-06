/**
 * @Title IPostTalkBO.java 
 * @Package com.std.forum.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午1:21:32 
 * @version V1.0   
 */
package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.PostTalk;

/** 
 * 点赞/收藏/打赏/举报/阅读
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:21:32 
 * @history:
 */
public interface IPostTalkBO extends IPaginableBO<PostTalk> {

    public int savePostTalk(String postCode, String userId, String type,
            String remark);

    public List<PostTalk> queryPostTalkSingleList(String postCode, String type);

    public List<PostTalk> queryPostTalkList(String postCode, String type,
            int limit);

    public long getPostTalkTotalCount(String postCode, String type);

    public List<PostTalk> queryPostTalkList(PostTalk condition);

    public PostTalk getPostTalk(String code);

    public PostTalk getPostTalkByCondition(String postCode, String userId,
            String type);

    public int removePostTalk(String code);
}
