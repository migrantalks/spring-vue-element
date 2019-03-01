package com.zgs.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author zgs
 * @since 2019/03/01
 */
@Data
@Table(name = "t_member")
public class Member implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	/**
	 * 注册日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "date")
	public Date date;

	/**
	 * 姓名
	 */
	@Column(name = "name", length = 50)
	public String name;

	/**
	 * 性别
	 */
	@Column(name = "sex")
	public Integer sex;
}
