package org.feather.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @projectName: spring-cloud
 * @package: org.feather.springcloud
 * @className: EurekaConsumerApplication
 * @author: feather
 * @description: TODO
 * @since: 2023-05-29 21:15
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaConsumerApplication {

    @Bean
    public RestTemplate  register(){
        return  new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaConsumerApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
