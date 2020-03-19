package com.yhj.code.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yhj.code.config.UserAuthentic;
import com.yhj.code.kit.HashKit;
import com.yhj.code.kit.RetKit;
import com.yhj.code.kit.StrKit;
import com.yhj.code.vo.AdminUser;
import com.yhj.code.vo.User;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;

@Service
public class ExportService {

	/**
	 *     用户管理
	 */
	public Map<String, Object> getList(Integer pn, Integer ps,UserAuthentic user,String search) {
		try {
			search = StrKit.isBlank(search)?"":"AND u.name like '%"+search+"%' or u.phone like '%"+search+"%' or u.idcard like '%"+search+"%'";
			List<User>  users = Db.use().query("SELECT u.* ,f.url,f.create_time as createTime from user u "
					+ " left join file f on f.openid = u.openid "
					+ " WHERE u.status=1 " + search, User.class);
			Integer count = users.size();
			users = users.stream().skip(ps * pn).limit(ps).collect(Collectors.toList());
			Map<String, Object> result = new HashMap<>();
			result.put("list", users);
			result.put("count", count); // 总条数
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	public RetKit addOrUpdateUser(AdminUser user) {
		try {
			List<AdminUser> isExit = Db.use().findAll(Entity.create("admin_user").set("user_name", user.getUserName()),AdminUser.class);
			if (user.getId() == null) {
				if (isExit.size()> 0) {
					return RetKit.fail("已存在此菜单");
				}
				
				Db.use().tx(db -> {
					Long userid = Db.use().insertForGeneratedKey(
						    Entity.create("admin_user")
						    .set("user_name", user.getUserName())
						    .set("remark_name", user.getRemarkName())
						    .set("password", HashKit.md5("123456"))
						    .set("status",1)
						);
					
					Db.use().insert(
						    Entity.create("admin_user_role")
						    .set("user_id", userid.intValue())
						    .set("role_id", user.getRoleId())
						);
				});
				
			} else {
				if(isExit.size()>0) {
					AdminUser old = isExit.get(0);
					if (!old.getRoleName().equals(user.getUserName())) {
						if (isExit != null) {
							return RetKit.fail("已存在此用户");
						}
					}
				
					Db.use().tx(db -> {
						Db.use().update(
							    Entity.create("admin_user")
							    .set("user_name", user.getUserName()),
							    Entity.create("admin_user")
							    .set("user_id", user.getId())
							);
						
						Db.use().update(
							    Entity.create("admin_user_role")
							    .set("role_id", user.getRoleId()),
							    Entity.create("admin_user_role")
							    .set("user_id", user.getId())
							);
					});
				}
			}
			return RetKit.ok();
		} catch (Exception e) {
			return RetKit.fail(e.getMessage());
		}
	}

	public RetKit delUser(List<Integer> ids) {
		try {
			if(Db.use().findAll(Entity.create("admin_user")).size()<=1) {
				return RetKit.fail("只剩一个用户无法继续删除！");
			}
			Db.use().tx(db -> {
				for (Integer userId : ids) {
					Db.use().del(
						    Entity.create("admin_user_role")
						    .set("user_id", userId)
						);
					Db.use().del(
						    Entity.create("admin_user")
						    .set("id", userId)
						);
				}
			});	
		} catch (Exception e) {
			return RetKit.fail(e.getMessage());
		}
		return RetKit.ok();
	}
}
