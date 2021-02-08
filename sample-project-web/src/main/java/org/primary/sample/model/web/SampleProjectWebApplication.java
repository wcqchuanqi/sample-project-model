package org.primary.sample.model.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * web项目启动入口
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/19
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.primary.sample.model.*"})
@EnableCaching
public class SampleProjectWebApplication extends SpringBootServletInitializer {
    /**
     * 如果需要外置的tomcat启动，启动类需要继承 SpringBootServletInitializer 并复写configure.
     * 如果不是使用外置tomcat是否继承都可以.
     * SpringApplicationBuilder 构建并封装了SpringApplication，最终调用 SpringApplication的run方法。
     * Spring boot简化开发，也就是用注解的方式取代了传统的xml。SpringBootServletInitializer就时原来的web.xml的替代品。
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SampleProjectWebApplication.class);

    }

    public static void main(String[] args) {
        //配置全局异步日志
//		System.setProperty("Log4jContextSelector",
//				"org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(SampleProjectWebApplication.class, args);
    }

}
