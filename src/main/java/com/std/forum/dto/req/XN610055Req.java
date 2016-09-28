package com.std.forum.dto.req;

/** 
 * 对帖子内容进行审核
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:43:00 
 * @history:
 */
public class XN610055Req {

    // 帖子编号（必填）
    private String code;

    // 审核结果(必填)
    private String status;

    // 审核人（必填）
    private String approver;

    // 审核说明（必填）
    private String approveNote;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
