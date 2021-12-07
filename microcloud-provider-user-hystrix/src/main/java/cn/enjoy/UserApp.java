package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xujianhao
 * @version 1.0
 * @description: User服务启动类
 * @date 2021/8/26 22:28
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
public class UserApp {
    public static void main(String[] args){
        SpringApplication.run(UserApp.class,args);
    }
}
