package com.std.forum.dto.req;

public class XN610044Req {

    // 帖子编号（必填）
    private String code;

    // 审核结果(必填)
    private String approveResult;

    // 审核人（必填）
    private String approver;

    // 审核说明（必填）
    private String approveNote;

    // 类型(必填)
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
