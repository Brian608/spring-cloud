package org.feather.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.feather.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: spring-cloud
 * @package: org.feather.springcloud.controller
 * @className: TestController
 * @author: feather
 * @description: TODO
 * @since: 2023-05-28 20:34
 * @version: 1.0
 */
@RestController
@Slf4j
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/sayHi")
    public  String sayHi(){
        return  "This is " +port;
    }

    @PostMapping("sayHi")
    public User sayHiPost(@RequestBody User user){
        log.info("You are "+user.getName());
        user.setPort(port);
        return  user;

    }



}
