package com.socialapppro.util;

public class StringUtils {
    static public boolean isAllNor(String str){
        return str == null;
    }

    static public boolean isAllSpan(String str){
        // 使用trim()方法去除字符串两端的空格
        String trimmed = str.trim();
        // 检查剩余字符串的长度是否为0
        return trimmed.isEmpty();
    }


}
