/**
 * @Title IKeywordBO.java 
 * @Package com.std.forum.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午1:21:32 
 * @version V1.0   
 */
package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Keyword;
import com.std.forum.enums.EReaction;

/** 
 * 关键词过滤
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:21:32 
 * @history:
 */
public interface IKeywordBO extends IPaginableBO<Keyword> {

    public Boolean isKeywordExist(String code);

    public String saveKeyword(Keyword data);

    public int refreshKeyword(Keyword data);

    public int removeKeyword(String code);

    public Keyword getKeyword(String code);

    public List<Keyword> queryKeywordList(Keyword condition);

    /**
     * 检查内容，返回关键词对象列表
     * @param content
     * @param level
     * @param reaction
     * @return 
     * @create: 2016年10月23日 下午2:42:28 xieyj
     * @history:
     */
    public List<Keyword> checkContent(String content, String level,
            EReaction reaction);

    /**
     * 过滤替换关键字
     * @param content
     * @param word
     * @return 
     * @create: 2016年10月16日 下午1:28:47 xieyj
     * @history:
     */
    public String replaceKeyword(String content, String word);
}
