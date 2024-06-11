package com.socialapppro.util;

public class WechatUtils {
    //填写自己的小程序开发员信息
    static String appid = "";
    static String secret = "";
    public  static String getOpenid(String code) {
        // 调用接口必要的参数
        StringBuilder data = new StringBuilder();
        // appid、secret定义在配置文件中，注入到项目里
        data.append("appid="+appid+"&");
        data.append("secret="+ secret+"&");
        data.append("js_code="+ code+"&");
        data.append("grant_type="+ "authorization_code");

        String response = HttpUtils.getRequest("https://api.weixin.qq.com/sns/jscode2session?" + data);
        return response;
    }
}
