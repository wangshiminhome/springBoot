package com.wsm.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.github.pagehelper.PageHelper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wsm.bean.ConfigBean;

@Configuration
public class SpringConfig {
	@Autowired
	private ConfigBean configbean;
	//配置数据库连接池
	@Bean
	public ComboPooledDataSource getDataSource() throws PropertyVetoException{
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setDriverClass(configbean.getDriverClassName());
		dataSource.setJdbcUrl(configbean.getUrl());
		dataSource.setUser(configbean.getUsername());
		dataSource.setPassword(configbean.getPassword());
		return dataSource;
	}
	//配置映射配置文件
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws PropertyVetoException{
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(this.getDataSource());
		//用来扫描配置文件的
		ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		try {
			sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlSessionFactoryBean;
	}
	//pagehelper分页查询
	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper=new PageHelper();
		Properties properties=new Properties();
		properties.setProperty("offsetAsPageNum","true");
		//rowBoundsWithCount设置为true时，使用 RowBounds 分页会进行 count 查询。
		properties.setProperty("rowBoundsWithCount","true");
		//reasonable 为 true，这时如果 pageNum<=0 会查询第一页，如果 pageNum>总页数 会查询最后一页
		properties.setProperty("reasonable","true");
		//pageSizeZero 为 true， 当 pageSize=0 或者 RowBounds.limit = 0 就会查询出全部的结果  
		properties.setProperty("pageSizeZero","true");
		        //配置mysql数据库的方言
		properties.setProperty("dialect","mysql");
		properties.setProperty("returnPageInfo","check");
		pageHelper.setProperties(properties);
		return pageHelper;
	}
}
