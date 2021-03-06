package com.jcoffee.oauth.app;

import com.jcoffee.commons.basics.util.port.PortApplicationEnvironmentPreparedEventListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan({"com.jcoffee.database.auth.client.mapper","com.jcoffee.database.auth.app.mapper"})
public class JcoffeeOauthApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JcoffeeOauthApplication.class);
        app.addListeners(new PortApplicationEnvironmentPreparedEventListener());
        app.run(args);
    }

}
