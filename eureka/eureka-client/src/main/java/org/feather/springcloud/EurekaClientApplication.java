package org.feather.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @projectName: spring-cloud
 * @package: org.feather.springcloud
 * @className: EurekaClientApplication
 * @author: feather
 * @description: TODO
 * @since: 2023-05-28 20:32
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClientApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
