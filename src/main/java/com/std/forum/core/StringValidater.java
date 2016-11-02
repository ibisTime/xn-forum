/**
 * @Title BlankValidater.java 
 * @Package com.ibis.account.validate 
 * @Description 
 * @author miyb  
 * @date 2015-5-6 上午9:11:33 
 * @version V1.0   
 */
package com.std.forum.core;

import org.apache.commons.lang3.StringUtils;

import com.std.forum.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2015-5-6 上午9:11:33 
 * @history:
 */
public class StringValidater {
    /** 
     * 判断参数是否为空
     * @param userId 
     * @create: 2015-3-17 下午6:40:34 miyb
     * @history: 
     */
    public static void validateBlank(String... params) {
        for (String param : params) {
            if (StringUtils.isBlank(param)) {
                throw new BizException("xn702000", "必填型入参，请按要求填写完整");
            }
        }
    }

    // 判别是否包含Emoji表情
    public static void validateEmoji(String param) {
        if (StringUtils.isNotBlank(param)) {
            int len = param.length();
            for (int i = 0; i < len; i++) {
                if (isEmojiCharacter(param.charAt(i))) {
                    throw new BizException("xn000000", "包含表情符号，请删除哦");
                }
            }
        }
    }

    private static boolean isEmojiCharacter(char codePoint) {
        return !((codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF)));
    }

    public static void validateNumber(String... params) {
        for (String param : params) {
            if (!StringUtils.isNumeric(param)) {
                throw new BizException("xn702000", "数字型入参，请按要求填写数字");
            }
        }
    }

    /** 
     * 判断钱的对错
     * @param userId 
     * @create: 2015-3-17 下午6:40:34 miyb
     * @history: 
     */
    public static void validateAmount(String... amounts) {
        for (String amountS : amounts) {
            Long amountL = null;
            try {
                amountL = Long.valueOf(amountS);
            } catch (Exception e) {
                throw new BizException("xn702000", "金额，请按要求填写数字");
            }

            if (Math.abs(amountL) < 1000) {
                throw new BizException("xn702000", "金额不能小于1块钱");
            }
        }
    }

    /**
     * string转化成Long
     * @param string
     * @return 
     * @create: 2015-5-7 下午3:47:13 miyb
     * @history:
     */
    public static Long toLong(String string) {
        Long amount = null;
        try {
            if (StringUtils.isNotBlank(string)) {
                amount = Long.valueOf(string);
            }
        } catch (Exception e) {
            // e.printStackTrace();
            throw new BizException("xn702000", "数字型入参，请按要求填写数字");
        }
        return amount;
    }

    /**
     * string转化成Integer
     * @param string
     * @return 
     * @create: 2015-5-7 下午3:47:13 miyb
     * @history:
     */
    public static Integer toInteger(String string) {
        Integer num = null;
        try {
            if (StringUtils.isNotBlank(string)) {
                num = Integer.valueOf(string);
            }
        } catch (Exception e) {
            throw new BizException("xn702000", "数字型入参，请按要求填写数字");
        }
        return num;
    }

    /**
     * string转化成Double
     * @param string
     * @return 
     * @create: 2016年10月11日 上午12:09:13 xieyj
     * @history:
     */
    public static Double toDouble(String string) {
        Double num = null;
        try {
            if (StringUtils.isNotBlank(string)) {
                num = Double.valueOf(string);
            }
        } catch (Exception e) {
            throw new BizException("xn702000", "浮点型入参，请按要求填写数字");
        }
        return num;
    }

    public static void main(String[] args) {
        // System.out.println(StringValidater.toLong("1000"));
        StringValidater.toDouble("100.1");
    }
}
