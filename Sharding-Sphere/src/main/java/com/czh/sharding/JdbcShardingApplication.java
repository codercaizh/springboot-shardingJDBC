package com.czh.sharding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;

/**
 * 入口

* @author 菜头君  

* @date 2018年5月19日
 */
@SpringBootApplication
public class JdbcShardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcShardingApplication.class, args);
	}
	
	/**
	 * 配置读写分离数据源
	 * @return
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Bean
	public DataSource dataSource() throws FileNotFoundException, SQLException, IOException {
		return MasterSlaveDataSourceFactory.createDataSource(ResourceUtils.getFile("classpath:sharding-jdbc.yml"));
	}
}
