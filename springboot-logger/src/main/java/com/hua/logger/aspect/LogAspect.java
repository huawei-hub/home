package com.hua.logger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.hua.jwt.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //传入的是切面对象,即出发这个AOP时被调用的那个方法,以获取所需要的"调用方法"以及"传入参数"
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //获取路径和ip
        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr();

        //获取用户token
        String token = request.getHeader("Authorization");

        String method= joinPoint.getSignature().getDeclaringTypeName() +
                "."+ joinPoint.getSignature().getClass();

        Object[] args=joinPoint.getArgs();

        content content = new content(url,ip,method,args);
        logger.info("Request:{}",content);
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void logAfterReturning(Object result){
        logger.info("Result:{}",result);
    }

    private class content{
        private String url;
        private String ip;
        private String method;
        private Object[] args;

        public content(String url, String ip, String method, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.method = method;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", method='" + method + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
