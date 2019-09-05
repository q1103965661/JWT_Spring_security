package com.alan.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author alan wang
 * @version 1.0
 * @date 2019/9/3 8:29
 */
@Configuration
@PropertySource(value = "classpath:druid.properties")
public class DruidConfiguration {
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
}
//
//  /**
//   * 注册一个StatViewServlet
//   *
//   * @return
//   */
//  @Bean
//  public ServletRegistrationBean druidStatViewServlet() {
//      //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
//      ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//
//      //添加初始化参数：initParams
//      //白名单：
//      servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//      //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
////        servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
//      //登录查看信息的账号密码.
//      servletRegistrationBean.addInitParameter("loginUsername", "admin");
//      servletRegistrationBean.addInitParameter("loginPassword", "123456");
//      //是否能够重置数据.
//      servletRegistrationBean.addInitParameter("resetEnable", "false");
//      return servletRegistrationBean;
//  }
//
//  /**
//   * 注册一个：filterRegistrationBean
//   *
//   * @return
//   */
//  @Bean
//  public FilterRegistrationBean druidStatFilter() {
//
//      FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//
//      //添加过滤规则.
//      filterRegistrationBean.addUrlPatterns("/*");
//
//      //添加不需要忽略的格式信息.
//      filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//      return filterRegistrationBean;
//  }

