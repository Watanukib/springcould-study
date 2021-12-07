package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "MICROCOULD-PRODUCT" , configuration = RibbonConfig.class)
@EnableFeignClients("cn.enjoy.service")
public class ConsumerFeginApp {

    public static void main(String[] args){
        SpringApplication.run(ConsumerFeginApp.class,args);
    }
}
