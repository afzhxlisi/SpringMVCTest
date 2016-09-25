package com.cn.hnust.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.constants.RedisUtil;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	IUserService userService;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		User u = userService.getUserById(1);
		model.addAttribute("user", u);  
		return "showUser";
	}
	
	@RequestMapping("/updateUserCache")
	public String updateUserCache(User user){
		Jedis jedis = null;
		try{
			jedis=RedisUtil.getJedis();
			if(jedis.get(String.valueOf(user.getId()))==null){
				jedis.set(String.valueOf(user.getId()), "1");
				user.setCreateTime(new Date());
				userService.updateByPrimaryKeySelective(user);
			}
		}finally{
			RedisUtil.returnResource(jedis);
		}
		return "showUser";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(User user){
//		Jedis jedis = null;
//		try{
//			jedis=RedisUtil.getJedis();
//			if(jedis.get(String.valueOf(user.getId()))==null){
//				jedis.set(String.valueOf(user.getId()), "1");
				user.setCreateTime(new Date());
				userService.updateByPrimaryKeySelective(user);
//			}
//		}finally{
//			RedisUtil.returnResource(jedis);
//		}
		return "showUser";
	}
	
	@RequestMapping("/rmRedis")
	public String rmRedis(User user){
		Jedis jedis = null;
		try{
			jedis=RedisUtil.getJedis();
			jedis.del(String.valueOf(user.getId()));
		}finally{
			RedisUtil.returnResource(jedis);
		}
		return "showUser";
	}
}
