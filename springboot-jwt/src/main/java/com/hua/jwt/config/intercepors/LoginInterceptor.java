package com.hua.jwt.config.intercepors;


import com.hua.jwt.config.RedisService;
import com.hua.jwt.entity.UserTokenDTO;
import com.hua.jwt.utile.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedisService redisService;

    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authToken = request.getHeader("Authorization");
        String token = authToken.substring("Bearer".length() + 1).trim();
        UserTokenDTO userTokenDTO = JWTUtil.parseToken(token);
        //1、判断请求是否有效
        if (redisService.get(String.valueOf(userTokenDTO.getId())) == null ||
                !redisService.get(String.valueOf(userTokenDTO.getId())).equals(token)) {
            return false;
        }
        //2、判断是否需要续期
        if (redisService.getExpireTime(String.valueOf(userTokenDTO.getId())) < 1 * 60 * 30) {
            redisService.set(String.valueOf(userTokenDTO.getId()), token);
            log.error("update token info, id is:{}, user info is:{}", userTokenDTO.getId(), token);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
