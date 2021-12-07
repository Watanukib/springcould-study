package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author xujianhao
 * @version 1.0
 * @description: Turbine启动类
 * @date 2021/8/26 22:58
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApp {
    public static void main(String[] args){
        SpringApplication.run(TurbineApp.class,args);
    }
}
