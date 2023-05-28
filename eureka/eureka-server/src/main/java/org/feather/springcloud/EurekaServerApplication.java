package org.feather.springcloud;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @projectName: spring-cloud
 * @package: org.feather.springcloud
 * @className: EurekaServerApplication
 * @author: feather
 * @description: TODO
 * @since: 2023-05-28 20:07
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {

        new SpringApplicationBuilder(EurekaServerApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
