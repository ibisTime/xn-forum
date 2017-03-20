package com.std.forum.dto.req;

/** 
 *  浏览帖子时，发现帖子内容存在问题，举报帖子
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:42:16 
 * @history:
 */
public class XN610043Reqt {

    // 帖子/评论编号（必填）
    private String code;

    // 举报人（必填）
    private String reporter;

    // 举报说明（必填）
    private String reportNote;

    // 类型(必填) 1 帖子，2 评论
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReportNote() {
        return reportNote;
    }

    public void setReportNote(String reportNote) {
        this.reportNote = reportNote;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
