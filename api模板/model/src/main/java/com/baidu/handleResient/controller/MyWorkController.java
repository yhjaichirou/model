package com.baidu.handleResient.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.handleResient.kit.RetKit;
import com.baidu.handleResient.kit.StrKit;
import com.baidu.handleResient.kit.WxResult;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.http.HttpUtil;

/**
 * 业务逻辑
 * @author Administrator
 *
 */
@RestController
public class MyWorkController {
	private static Log log = LogFactory.getLog(MyWorkController.class);
	
	@Value("${appid}")
	private String appid;
	@Value("${secret}")
	private String secret;
	@Value("${dd_userid}")
	private String userid;
	@Value("${dd_deptId}")
	private String deptId;
	
	private String firstMsg = "联通VIP政企客户宽带问题专属通道，请您发起服务预约，我们及时安排工作人员上门服务。联系电话：18647415861    服务监督电话：15504740005";
	
	@RequestMapping(value ="my/test" , method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void test() {
		System.out.println(appid);
		System.out.println(secret);
		System.out.println(firstMsg);
		System.out.println(userid);
	
		System.out.println(	Long.parseLong(deptId));
	}
	
	@Autowired
	private CacheManager cacheManager;
	
	/**
	 * -------------------------微信在使用的 接口--------------------------
	 */
	@RequestMapping(value ="/auth" , method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RetKit getAuthentication(String code) {
		try {
			if(StrKit.isBlank(code)) {
				return RetKit.fail("认证码不能为空！");
			}
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("appid", appid);
			paramMap.put("secret", secret);
			paramMap.put("js_code", code);
			paramMap.put("grant_type", "authorization_code");
			String result3= HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session", paramMap);
			WxResult appuser = JSONObject.parseObject(result3, WxResult.class);
			if(appuser.getErrcode() != null) {
				return RetKit.fail(appuser.getErrmsg());
			}
			return RetKit.okData(appuser);
		} catch (Exception e) {
			e.printStackTrace();
			return RetKit.fail(e.getMessage());
		}
	}
	
	
	
}