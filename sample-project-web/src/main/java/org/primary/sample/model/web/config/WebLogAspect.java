package org.primary.sample.model.web.config;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.primary.sample.model.common.util.StringComUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 * 关于webLog的Aspect
 * 由于需要对http请求做特殊处理，并需要spring-web支持，所以放在了web项目。
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/19
 */
@Aspect
@Order(5)
@Component
@Slf4j
public class WebLogAspect {
    /**
     * 时间统计
     */
    ThreadLocal<Long> timeInfo = new ThreadLocal<>();

    /**
     * 定义切入点
     */
    @Pointcut("@annotation(org.primary.sample.model.common.log.WebLog)")
    public void webLog() {
    }

    /**
     * 请求日志
     *
     * @param joinPoint 连接点
     * @throws Throwable 异常
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        timeInfo.set(Instant.now().toEpochMilli());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info(StringComUtils.append("URL : ", request.getRequestURL().toString()));
        log.info(StringComUtils.append("HTTP_METHOD : ", request.getMethod()));
        log.info(StringComUtils.append("IP : ", request.getRemoteAddr()));
        log.info(StringComUtils.append("CLASS_METHOD : ", joinPoint.getSignature().getDeclaringTypeName(), ".",
                joinPoint.getSignature().getName()));
        log.info(StringComUtils.append("ARGS : ", JSONUtil.toJsonStr(joinPoint.getArgs())));
    }

    /**
     * 返回参数
     *
     * @param ret 返回值
     * @throws Throwable 异常
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info(StringComUtils.append("RESPONSE : ", JSONUtil.toJsonStr(ret)));
        log.info(StringComUtils.append("SPEND TIME : ", String.valueOf(Instant.now().toEpochMilli() - timeInfo.get())));
        timeInfo.remove();
    }
}
