package com.dlw.demo.controller;

import org.nutz.ssdb4j.spi.Response;
import org.nutz.ssdb4j.spi.SSDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 测试ssdb
 * @Author diaoliwei
 * @Date 2018/12/27 11:02
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    private final static Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private SSDB ssdb;

    @RequestMapping("/index")
    public Map<String, Object> index(){
        Map<String, Object> map = new HashMap<String, Object>();

        log.info("----SSDB connected ----- {}", ssdb);
        Response response = ssdb.get("test");
        if (!response.ok()) {
            log.info("SSDB get status is not ok !");
            ssdb.set("test", "test-------");
        } else {
            map.put("status", response.ok());
            map.put("result", response.asString());
        }
        return map;
    }
}
