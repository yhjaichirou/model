package com.baidu.handleResient.config;

/**
 * 项目中的常量定义类
 */
public class Constant {
    /**
     * 企业corpid, 需要修改成开发者所在企业
     */
    public static final String CORP_ID = "ding4f45d3e6d48275a835c2f4657eb6378f";
    /**
     * 应用的AppKey，登录开发者后台，点击应用管理，进入应用详情可见
     */
    public static final String APPKEY = "ding33kfivwu6f9sscsy";
    /**
     * 应用的AppSecret，登录开发者后台，点击应用管理，进入应用详情可见
     */
    public static final String APPSECRET = "Z03BulpDpbxLSswTrSdlMG3P0lplSJK3ONweWy7qP_6eDN0QytI2jsbS6a6zSY-V";

    /**
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成
     */
    public static final String ENCODING_AES_KEY = "Ah26gWDSylDfox1erouKkbtHnaVbyNRVpIJY7mqZrtd";

    /**
     * 加解密需要用到的token，企业可以随机填写。如 "12345"
     */
    public static final String TOKEN = "12232";

    /**
     * 应用的agentdId，登录开发者后台可查看
     */
    public static final Long AGENTID = (long) 468419499;

    /**
     * 审批模板唯一标识，可以在审批管理后台找到
     */
//    public static final String PROCESS_CODE = "PROC-C6302B17-4E5D-488A-873D-A820F5078ACF";
    public static final String PROCESS_CODE = "PROC-ED644583-9031-4605-AE4C-D8266E2135C9";
    /**
     * 回调host
     */
    public static final String CALLBACK_URL_HOST = "https://brinch.wlcbhc.com/process";
//    public static final String CALLBACK_URL_HOST = "https://brinch.wlcbhc.com:8082/process";
//    public static final String CALLBACK_URL_HOST = "https://brinch.wlcb.net:8082/process";
    
    /**
     * 全局  首要审批人
     */
    public static String processUser = "";
}
