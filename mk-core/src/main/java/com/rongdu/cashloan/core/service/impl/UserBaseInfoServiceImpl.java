package com.rongdu.cashloan.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
import com.rongdu.cashloan.core.model.ManagerUserModel;
import com.rongdu.cashloan.core.model.UserBaseInfoModel;
import com.rongdu.cashloan.core.model.UserWorkInfoModel;
import com.rongdu.cashloan.core.service.UserBaseInfoService;


/**
 * 用户详情表ServiceImpl
 * 
 * @author lyang
 * @version 1.0.0
 * @date 2017-02-14 11:08:04
 * Copyright 杭州融都科技股份有限公司  cl All Rights Reserved
 * 官方网站：www.erongdu.com
 * 
 * 未经授权不得进行修改、复制、出售及商业使用
 */
 
@Service("userBaseInfoService")
public class UserBaseInfoServiceImpl extends BaseServiceImpl<UserBaseInfo, Long> implements UserBaseInfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserBaseInfoServiceImpl.class);
	
    @Resource
    private UserBaseInfoMapper userBaseInfoMapper;
 
	@Override
	public BaseMapper<UserBaseInfo, Long> getMapper() {
		return  userBaseInfoMapper;
	}
	
	@Override
	public UserBaseInfo findByUserId(Long userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		UserBaseInfo baseInfo = null;
		try {
			baseInfo = userBaseInfoMapper.findSelective(paramMap);
		} catch (Exception e) {
			logger.error("查询用户基本信息异常", e);
		}

		return baseInfo;
	}

	@Override
	public UserBaseInfo findSelective(Map<String, Object> paramMap) {
		return userBaseInfoMapper.findSelective(paramMap);
	}

	@Override
	public List<Map<String, Object>> getDictsCache(String type) {
		return userBaseInfoMapper.getDictsCache(type);
	}

	@Override
	public ManagerUserModel getBaseModelByUserId(Long userId) {
		return userBaseInfoMapper.getBaseModelByUserId(userId);
	}

	@Override
	public int updateState(long id, String state) {
		int i = 0;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", id);
		UserBaseInfo base=userBaseInfoMapper.findSelective(paramMap);
		if (base != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", base.getId());
			map.put("state", state);
			i = userBaseInfoMapper.updateSelective(map);
		}
		return i;
	}

	@Override
	public UserWorkInfoModel getWorkInfo(Long userId){
		return userBaseInfoMapper.findWorkInfo(userId);
	}

	
	public void addBlacklist(String phone) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("phone", phone);
		UserBaseInfo userBaseInfo = userBaseInfoMapper.findSelective(param);
		if(userBaseInfo != null){
			userBaseInfo.setState(UserBaseInfoModel.USER_STATE_BLACK);
			userBaseInfo.setBlackReason("黑名单用户");
			userBaseInfoMapper.update(userBaseInfo);
		}
	}

	
	public boolean isBlacklist(String phone) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("phone", phone);
		UserBaseInfo userBaseInfo = userBaseInfoMapper.findSelective(param);
		if(userBaseInfo != null && UserBaseInfoModel.USER_STATE_BLACK.equals(userBaseInfo.getState())){
			return true;
		}
		return false;
	}

}