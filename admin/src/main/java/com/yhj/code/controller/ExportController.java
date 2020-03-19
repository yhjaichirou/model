package com.yhj.code.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhj.code.config.UserAuthentic;
import com.yhj.code.kit.RetKit;
import com.yhj.code.service.ExportService;

@Controller
@RequestMapping("/export")
@CrossOrigin
public class ExportController {
	
	@Resource
	private ExportService service;
	
	@RequestMapping("download")
	public String download(HttpServletRequest  request,HttpServletResponse response) {
		return "/views/export/download";
	}
	
	/**
	 *    超管后台 用户管理
	 */
	@RequestMapping("download/getList")
	@ResponseBody
	public RetKit getList(@PathParam("search")String search,@PathParam("limit")Integer limit,@PathParam("page")Integer page) {
		UserAuthentic user = (UserAuthentic)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> map = service.getList(page-1,limit,user,search);
		return RetKit.ok_table_data(map.get("list"),(Integer)map.get("count"));
	}


//	@RequestMapping("user/addorupdate")
//	@ResponseBody
//	public RetKit addOrUpdateUser(AdminUser pr) {
//		return service.addOrUpdateUser(pr);
//	}
//	
//	@RequestMapping("user/del")
//	@ResponseBody
//	public RetKit delUser(HttpServletRequest request) {
//		UserAuthentic user = (UserAuthentic)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String _ids = request.getParameter("ids");
//		List<Integer> ids = JSONObject.parseArray(_ids, Integer.class); 
//		if(ids.contains(user.getId())) {
//			RetKit.fail("当前用户无法删除！");
//		}
//		return service.delUser(ids);
//	}
}
