package com.std.forum.dto.req;

public class XN610054Req {

    // 帖子编号（必填）
    private String code;

    // 举报人（必填）
    private String reporter;

    // 举报说明（必填）
    private String reportNote;

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
}
