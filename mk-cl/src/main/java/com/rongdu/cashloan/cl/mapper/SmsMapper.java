package com.rongdu.cashloan.cl.mapper;

import java.util.Map;

import com.rongdu.cashloan.cl.domain.Sms;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

/**
 * 短信记录Dao
 * 
 * @author lyang
 * @version 1.0.0
 * @date 2017-03-09 14:48:24
 * Copyright 杭州融都科技股份有限公司  arc All Rights Reserved
 * 官方网站：www.erongdu.com
 * 
 * 未经授权不得进行修改、复制、出售及商业使用
 */
@RDBatisDao
public interface SmsMapper extends BaseMapper<Sms,Long> {

	/**
	 * 查询最新一条短信记录
	 * @param data
	 * @return
	 */
	Sms findTimeMsg(Map<String, Object> data);

    /**
     * 查询某号码某种类型当天已发送次数
     * @param data
     * @return
     */
    int countDayTime(Map<String, Object> data);
    

    /**
     * 根据订单号修改短信记录
     * @param data
     * @return
     */
    int updateByOrderNo(Map<String, Object> paramMap);

    /**
     * 查询某号码某种类型一共已发送次数
     * @param data
     * @return
     */
	int countAllTime(Map<String, Object> data);

}
