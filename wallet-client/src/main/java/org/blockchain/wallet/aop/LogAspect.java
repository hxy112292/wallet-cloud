package org.blockchain.wallet.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hxy
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * ..表示包及子包 该方法代表controller层的所有方法  TODO 路径需要根据自己项目定义
     */
    @Pointcut("execution(public * org.blockchain.wallet.controller..*.*(..))")
    public void controllerMethod() {
    }


    /**
     * 方法执行前
     *
     * @param joinPoint
     * @throws Exception
     */
    @Before("controllerMethod()")
    public void LogRequestInfo(JoinPoint joinPoint) {

        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            log.info("request url: " + request.getRequestURL());
            log.info("request remoteAddr: " + request.getRemoteAddr());
            log.info("request method: " + request.getMethod());
            log.info("request authorization: " + request.getHeader("Authorization"));
            if((request.getMethod().equals(HttpMethod.GET.toString())) && request.getQueryString() != null) {
                log.info("request queryString: " + URLDecoder.decode(request.getQueryString(), "UTF-8"));
            } else if(joinPoint.getArgs().length != 0){
                Object obj = joinPoint.getArgs()[0];
                Map map = getKeyAndValue(obj);
                log.info("request body: " + JSON.toJSONString(map));
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
        }
    }


    /**
     * 方法执行后
     *
     * @param object
     * @throws Exception
     */
    @AfterReturning(returning = "object", pointcut = "controllerMethod()")
    public void logResultVOInfo(Object object) throws Exception {
        if(object == null) {
            log.info("response result：" + null);
            return;
        }
        log.info("response result：" + JSON.toJSONString(object));
    }


    private Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = new HashMap<>();
        // 得到类对象
        Class cla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = cla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); // 设置些属性是可以访问的
            Object val = new Object();
            try {
                val = f.get(obj);
                // 得到此属性的值
                map.put(f.getName(), val);// 设置键值
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.toString());
            }

        }
        return map;
    }
}

