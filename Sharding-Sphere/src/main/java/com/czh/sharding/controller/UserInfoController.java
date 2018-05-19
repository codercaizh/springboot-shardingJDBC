package com.czh.sharding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.czh.sharding.model.UserInfo;
import com.czh.sharding.repository.UserInfoRepository;

/**
 * 用户信息控制器

* @author 菜头君  

* @date 2018年5月19日
 */
@RestController
public class UserInfoController {
	@Autowired
	UserInfoRepository userInfoRepository;
	
	/**
	 * 获取所有用户信息
	 * @return
	 */
	@GetMapping("/userinfo")
	public List<UserInfo> getUserInfos(){
		return userInfoRepository.findAll();
	}
	
	/**
	 * 增加新用户
	 * @param name
	 * @return
	 */
	@GetMapping("/userinfo/{name}")
	public UserInfo addUserInfo(@PathVariable String name){
		UserInfo userInfo = new UserInfo();
		userInfo.setName(name);
		return userInfoRepository.save(userInfo);
	}
	
	/**
	 * 增加新用户后再立即查找该用户信息
	 * @param name
	 * @return
	 */
	@GetMapping("/userinfo/wr/{name}")
	public UserInfo writeAndRead(@PathVariable String name) {
		UserInfo userInfo = new UserInfo();
		userInfo.setName(name);
		userInfoRepository.saveAndFlush(userInfo);
		return userInfoRepository.findOne(userInfo.getId());
	}
}
