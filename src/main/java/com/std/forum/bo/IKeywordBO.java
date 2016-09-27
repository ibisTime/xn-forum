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
}
