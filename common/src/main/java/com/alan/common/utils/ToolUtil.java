package com.alan.common.utils;

import java.security.MessageDigest;

/**
 * @Author yzhangm
 * @Date 2019/9/5 9:47
 */
public class ToolUtil {

    /**
     * 用户密码加密操作
     *
     * @param password 用户的密码
     * @param salt     用户的密码盐
     * @return
     */
    public final static String passwordByMd5(String password, String salt) {
        return encrypByMd5(encrypByMd5(encrypByMd5(password + salt)));
    }

    /**
     * 32位Md5加密操作
     *
     * @param context
     * @return
     */
    public final static String encrypByMd5(String context) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        md.update(context.getBytes());
        byte[] encryContext = md.digest();
        int i;
        StringBuffer buf = new StringBuffer("");
        for (int offset = 0; offset < encryContext.length; offset++) {//做相应的转化（十六进制）
            i = encryContext[offset];
            if (i < 0) i += 256;
            if (i < 16) buf.append("0");
            buf.append(Integer.toHexString(i));
        }
        return buf.toString().toUpperCase();
    }

}
