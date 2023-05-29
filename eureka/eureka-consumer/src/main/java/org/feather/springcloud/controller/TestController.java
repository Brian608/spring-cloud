package org.feather.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.feather.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @projectName: spring-cloud
 * @package: org.feather.springcloud.controller
 * @className: TestController
 * @author: feather
 * @description: TODO
 * @since: 2023-05-29 21:16
 * @version: 1.0
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){
        ServiceInstance instance=client.choose("eureka-client");
        if (instance ==null){
            return  "no available instances";
        }
        String target = String.format("http://%s:%s/sayHi", instance.getHost(), instance.getUri());
        log.info("url is {}",target);
        return    restTemplate.getForObject(target,String.class);
    }

    @PostMapping("/hello")
    public User helloPost(){
        ServiceInstance instance=client.choose("eureka-client");
        if (instance ==null){
            return  null ;
        }
        String target = String.format("http://%s:%s/sayHi", instance.getHost(), instance.getUri());
        log.info("url is {}",target);
        User user=new User();
        user.setName("eureka consumer ");
        return    restTemplate.postForObject(target,user,User.class);
    }
}
