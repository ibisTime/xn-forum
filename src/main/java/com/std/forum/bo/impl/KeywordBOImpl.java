/**
 * @Title KeywordBOImpl.java 
 * @Package com.std.forum.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午5:37:39 
 * @version V1.0   
 */
package com.std.forum.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IKeywordBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.dao.IKeywordDAO;
import com.std.forum.domain.Keyword;
import com.std.forum.enums.EPrefixCode;

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
            code = EPrefixCode.KEYWORD.getCode();
            data.setCode(code);
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
}
