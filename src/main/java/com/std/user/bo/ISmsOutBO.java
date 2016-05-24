package com.std.user.bo;

public interface ISmsOutBO {
    /**
     * 发送下行短信
     * @param mobile
     * @param content
     * @param bizType 业务类型，直接决定短信模板的选用
     * @create: 2015年9月19日 上午10:25:52 myb858
     * @history:
     */
    public void sendSmsOut(String mobile, String content, String bizType);

    /**
     * 验证短信验证码
     * @param mobile
     * @param captcha
     * @param bizType 
     * @create: 2016年1月14日 下午3:49:54 myb858
     * @history:
     */
    public void checkCaptcha(String mobile, String captcha, String bizType);

    /**
     * 发送短信验证码
     * @param mobile
     * @param bizType 
     * @create: 2016年1月17日 下午2:09:51 myb858
     * @history:
     */
    public void sendCaptcha(String mobile, String bizType);
}
