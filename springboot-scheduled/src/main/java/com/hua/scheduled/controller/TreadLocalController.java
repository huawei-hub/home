package com.hua.scheduled.controller;

import com.hua.scheduled.config.MyTreadLocal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TreadLocalController {

    @GetMapping("/getTreadLocal")
    public String getTreadLocal() {
        Map<String, Object> map = MyTreadLocal.getLocal();
        return map.get("name").toString();
    }

    @PostMapping("/add")
    public String addTreadLocal(@RequestBody Map map) {
        MyTreadLocal.setLocal(map);
        return "success";
    }
}
