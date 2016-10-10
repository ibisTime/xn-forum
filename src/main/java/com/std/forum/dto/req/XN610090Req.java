package com.std.forum.dto.req;

/** 
 *  新增关键词
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:46:58 
 * @history:
 */
public class XN610090Req {

    // 关键词(必填)
    private String word;

    // 权重(必填)
    private String weight;

    // 作用等级(必填)
    private String level;

    // 反应(必填)
    private String reaction;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
