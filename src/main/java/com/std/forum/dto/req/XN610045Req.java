package com.std.forum.dto.req;

import java.util.List;

public class XN610045Req {

    // 帖子/评论编号（必填）
    private List<String> codeList;

    // 审核结果(必填)
    private String approveResult;

    // 审核人（必填）
    private String approver;

    // 审核说明（必填）
    private String approveNote;

    // 类型(必填)
    private String type;

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
