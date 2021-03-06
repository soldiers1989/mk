package com.rongdu.cashloan.manage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.context.Constant;
import com.rongdu.cashloan.core.common.util.RdPage;
import com.rongdu.cashloan.core.common.util.ServletUtils;

/**
 * 风控数据
 * 1、平台数据日报
 * @author caitt
 * @version 1.0
 * @date 2017年3月20日下午4:54:48
 * Copyright 杭州融都科技股份有限公司 现金贷  All Rights Reserved
 * 官方网站：www.erongdu.com
 * 
 * 未经授权不得进行修改、复制、出售及商业使用
 */
@Controller
@Scope("prototype")
public class SystemRiskController extends ManageBaseController {

	
	/**
	 * 平台数据日报
	 * @param response
	 * @param current
	 * @param pageSize
	 * @param search
	 * @throws Exception
	 */
	@RequestMapping(value = "/modules/manage/rc/day.htm")
	public void dayData(HttpServletResponse response,
			@RequestParam(value="current")Integer current,
			@RequestParam(value="pageSize")Integer pageSize,
			@RequestParam("search")String search) throws Exception {
		Map<String,Object> params = JSONObject.parseObject(search);
		//Page<SystemDayData> page = systemRcService.findDayData(params,current, pageSize);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put(Constant.RESPONSE_DATA, null);
		result.put(Constant.RESPONSE_DATA_PAGE, new RdPage(null));
		result.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
		result.put(Constant.RESPONSE_CODE_MSG, "查询成功");
		ServletUtils.writeToResponse(response,result);
	}
	
	/**
	 * 每日通过率
	 * @param response
	 * @param current
	 * @param pageSize
	 * @param search
	 * @throws Exception
	 */
	@RequestMapping(value = "/modules/manage/rc/dayApr.htm")
	public void dayApr(HttpServletResponse response,
			@RequestParam(value="current")Integer current,
			@RequestParam(value="pageSize")Integer pageSize,
			@RequestParam("search")String search) throws Exception {
		Map<String,Object> params = JSONObject.parseObject(search);
		//Page<DayPassApr> page = systemRcService.findDayApr(params,current, pageSize);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put(Constant.RESPONSE_DATA, null);
		result.put(Constant.RESPONSE_DATA_PAGE, new RdPage(null));
		result.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
		result.put(Constant.RESPONSE_CODE_MSG, "查询成功");
		ServletUtils.writeToResponse(response,result);
	}
}
