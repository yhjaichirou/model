package com.yhj.code;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.yhj.code.kit.MDateUtil;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

//@EnableScheduling
//@EnableCaching
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class CodeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
//		long current=System.currentTimeMillis();//当前时间毫秒数
//        long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
		try {
			Date date2 = DateUtil.parse("2020-01-30");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-30");
			Date endOfDay = DateUtil.endOfDay(date2);
			System.out.println(date.getTime());
			System.out.println(endOfDay.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SpringApplication.run(CodeApplication.class, args);
	}

	/**
	 * 打包war 必须添加
	 */
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(CodeApplication.class);
	 }
}
