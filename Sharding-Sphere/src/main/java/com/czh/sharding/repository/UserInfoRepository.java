package com.czh.sharding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.czh.sharding.model.UserInfo;

/**
 * 用户表操作接口

* @author 菜头君  

* @date 2018年5月19日
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer>{

}
