package com.yhj.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yhj.code.kit.StrKit;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

@Component
public class Quartz {
	private static final Log log = LogFactory.get();

	
	
	/**
	 * 定期   每隔一分钟 检查accessToken
	 */
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void targetOverdue() {
		log.info("----检测accessToken是否过期----");
		
	}
}
