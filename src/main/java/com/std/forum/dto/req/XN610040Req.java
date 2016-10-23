package com.std.forum.dto.req;

/** 
 * 发布帖子，填写帖子基本信息
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:40:29 
 * @history:
 */
public class XN610040Req {

    // 标题（必填）
    private String title;

    // 内容（必填）
    private String content;

    // 多张图片（选填）
    private String pic;

    // 所属板块（必填）
    private String plateCode;

    // 发布人（必填）
    private String publisher;

    // 是否发布
    private String isPublish;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish;
    }
}
