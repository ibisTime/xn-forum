/**
 * @Title IAccountBO.java 
 * @Package com.ibis.account.bo 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:15:49 
 * @version V1.0   
 */
package com.std.forum.bo;

public interface IAccountBO {

    /**
     * 用户间划账
     * @param fromUserId
     * @param toUserId
     * @param direction
     * @param amount
     * @param fee
     * @param remark 
     * @create: 2016年9月28日 下午8:10:25 xieyj
     * @history:
     */
    public void doTransferUsers(String fromUserId, String toUserId,
            String direction, Long amount, Long fee, String remark);
}
