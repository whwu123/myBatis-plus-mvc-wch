package com.baomidou.springmvc.model.system;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldIgnore;

/**
 *
 * 系统用户表
 *
 */
@TableName("sys_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 用户ID */
	private Long id;

	/** 用户名 */
	private String name;

	/** 用户年龄 */
	private Integer age;

	/** 自定义填充的创建时间 */
	@TableField(ignore = FieldIgnore.INSERT)// 该注解插入忽略验证，自动填充
	private Date ctime;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
}