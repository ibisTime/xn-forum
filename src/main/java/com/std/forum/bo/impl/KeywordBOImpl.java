/**
 * @Title KeywordBOImpl.java 
 * @Package com.std.forum.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午5:37:39 
 * @version V1.0   
 */
package com.std.forum.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IKeywordBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IKeywordDAO;
import com.std.forum.domain.Keyword;
import com.std.forum.enums.EBoolean;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.enums.EReaction;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午5:37:39 
 * @history:
 */
@Component
public class KeywordBOImpl extends PaginableBOImpl<Keyword> implements
        IKeywordBO {

    @Autowired
    private IKeywordDAO keywordDAO;

    /** 
     * @see com.std.forum.bo.IKeywordBO#saveKeyword(com.std.forum.domain.Keyword)
     */
    @Override
    public String saveKeyword(Keyword data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EPrefixCode.KEYWORD.getCode());
            data.setCode(code);
            data.setUpdateDatetime(new Date());
            keywordDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.std.forum.bo.IKeywordBO#refreshKeyword(com.std.forum.domain.Keyword)
     */
    @Override
    public int refreshKeyword(Keyword data) {
        int count = 0;
        if (data != null && data.getCode() != null) {
            data.setUpdateDatetime(new Date());
            count = keywordDAO.update(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.IKeywordBO#getKeyword(java.lang.String)
     */
    @Override
    public Keyword getKeyword(String code) {
        Keyword result = null;
        if (StringUtils.isNotBlank(code)) {
            Keyword condition = new Keyword();
            condition.setCode(code);
            result = keywordDAO.select(condition);
        }
        return result;
    }

    /** 
     * @see com.std.forum.bo.IKeywordBO#queryKeywordList(com.std.forum.domain.Keyword)
     */
    @Override
    public List<Keyword> queryKeywordList(Keyword condition) {
        return keywordDAO.selectList(condition);
    }

    /** 
     * @see com.std.forum.bo.IKeywordBO#removeKeyword(java.lang.String)
     */
    @Override
    public int removeKeyword(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Keyword condition = new Keyword();
            condition.setCode(code);
            count = keywordDAO.delete(condition);
        }
        return count;
    }

    @Override
    public Boolean isKeywordExist(String code) {
        Boolean count = false;
        if (StringUtils.isNotBlank(code)) {
            Keyword condition = new Keyword();
            condition.setCode(code);
            if (null != keywordDAO.select(condition)) {
                count = true;
            }
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.IKeywordBO#checkContent(java.lang.String)
     */
    @Override
    public List<Keyword> checkContent(String content, String level,
            EReaction reaction) {
        List<Keyword> resultList = new ArrayList<Keyword>();
        // 针对等级
        Keyword condition = new Keyword();
        condition.setLevel(level);
        condition.setWeightStart(0.5);
        condition.setReaction(reaction.getCode());
        List<Keyword> list = keywordDAO.selectList(condition);
        for (Keyword keyword : list) {
            if (content.indexOf(keyword.getWord()) >= 0) {
                resultList.add(keyword);
            }
        }
        // 针对所有
        condition.setLevel(EBoolean.NO.getCode()); // level=0 所有
        condition.setWeightStart(0.5);
        List<Keyword> allList = keywordDAO.selectList(condition);
        for (Keyword keyword : allList) {
            if (content.indexOf(keyword.getWord()) >= 0) {
                resultList.add(keyword);
            }
        }
        return resultList;
    }

    @Override
    public String replaceKeyword(String content, String word) {
        String replacement = "";
        for (int i = 0; i < word.length(); i++) {
            replacement += "*";
        }
        content = content.replaceAll(word, replacement);
        return content;
    }
}
