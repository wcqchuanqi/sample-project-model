package org.primary.sample.model.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleProjectWebApplication {

	public static void main(String[] args) {
		//配置全局异步日志
//		System.setProperty("Log4jContextSelector",
//				"org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		SpringApplication.run(SampleProjectWebApplication.class, args);
	}

}
