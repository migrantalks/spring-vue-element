package com.zgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zgs
 * @since 2019/03/01
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.zgs.base.BaseMapper","com.zgs.dao"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
