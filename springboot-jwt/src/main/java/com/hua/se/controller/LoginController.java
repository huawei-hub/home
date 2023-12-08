package com.hua.se.controller;

import com.hua.se.entity.UserTokenDTO;
import com.hua.se.entity.UserVo;
import com.hua.se.utile.JWTUtil;
import com.hua.se.config.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoginController {
    List<UserVo> userVoList = new ArrayList<>();

    {
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setUsername("root");
        userVo.setPassword("root");
        userVoList.add(userVo);
    }

    @Resource
    private RedisService redisService;

    @GetMapping("/login")
    public String login(String username, String password) {
        //1、查询user
        List<UserVo> list = userVoList.stream().filter(e -> e.getUsername().equals(username)).collect(Collectors.toList());
        UserVo userVo = list.get(0);
        if (userVo == null) {
            throw new RuntimeException("用户名不存在！");
        }
        if (!userVo.getPassword().equals(password)) {
            throw new RuntimeException("用户密码不正确！");
        }
        //2.用户名密码正确生成token
        UserTokenDTO userTokenDTO = new UserTokenDTO();
        userTokenDTO.setId(userVo.getId());
        userTokenDTO.setUsername(userVo.getUsername());
        userTokenDTO.setGmtCreate(System.currentTimeMillis());
        String jwt = JWTUtil.generateToken(userTokenDTO);

        //3.存入token至redis
        redisService.set(String.valueOf(userVo.getId()), jwt);
        return jwt;
    }

    @GetMapping("/logout")
    public boolean loginOut(String id) {
        boolean result = redisService.delete(id);
        if (!result) {
            throw new RuntimeException("退出失败！");
        }
        return true;
    }

    @GetMapping("/test")
    public String test() {
        return "success";
    }

}
