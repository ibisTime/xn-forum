package com.std.forum.domain;

import java.util.Date;

import com.std.forum.dao.base.ABaseDO;

/**
 * 关键词过滤
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:11:17 
 * @history:
 */
public class Keyword extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 关键词
    private String word;

    // 权重
    private Double weight;

    // 作用等级
    private String level;

    // 反应
    private String reaction;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // *************db properties*******************
    private Double weightStart;

    private String wordForQuery;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getWeightStart() {
        return weightStart;
    }

    public void setWeightStart(Double weightStart) {
        this.weightStart = weightStart;
    }

    public String getWordForQuery() {
        return wordForQuery;
    }

    public void setWordForQuery(String wordForQuery) {
        this.wordForQuery = wordForQuery;
    }
}
