package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author xujianhao
 * @version 1.0
 * @description:  HystrixDashboard启动类
 * @date 2021/8/26 22:03
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApp {
    public static void main(String[] args){
        SpringApplication.run(HystrixDashboardApp.class,args);
    }
}
