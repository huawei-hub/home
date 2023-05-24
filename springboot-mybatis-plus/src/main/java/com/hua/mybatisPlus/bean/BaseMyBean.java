package com.hua.mybatisPlus.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
* @Description: mybatis实体基类
* @Date: 2022-10-31 16:10:47
* @Author: 陈文波
*/
public abstract class BaseMyBean {


	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	* @Description: bean初始化
	* @Date: 2022-10-31 16:10:31
	* @Author: 陈文波
	*/
	public BaseMyBean createDefault() {
		return this;
	}

}
